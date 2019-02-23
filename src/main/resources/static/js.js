let detected = false;

$(document).ready(function() {
  $(".continueToNextPane").on('click',function(element) {
    var nextPane = $(element.currentTarget).attr("nextPane");

    if(nextPane === 'scanner'){
      detected = false;
      $.ajax(
          {url: "./register",
            success: function(result){
              startAndStopScanner()
            }
          }
      );

    }else if(nextPane === 'history'){

    }else if(nextPane === 'rewards'){
      $.ajax(
          {url: "./cityTemp/Chicago",
            success: function(result){
              $("#temperature").html(result.averageTemperature + " C");
            }
          }
      );
    }

    $(".pane").addClass('hidden');
    $("#"+nextPane).addClass('frontPane');
    $("#"+nextPane).removeClass('hidden');
  });
});

var _scannerIsRunning = false;



function startScanner() {
  Quagga.init({
    inputStream: {
      name: "Live",
      type: "LiveStream",
      target: document.querySelector('#scanner-container'),
      constraints: {
        width: 500,
        height: 400,
        facingMode: "environment"
      },
    },
    decoder: {
      readers: [
        "code_128_reader",
        "ean_reader",
        "ean_8_reader",
        "code_39_reader",
        "code_39_vin_reader",
        "codabar_reader",
        "upc_reader",
        "upc_e_reader",
        "i2of5_reader"
      ],
      debug: {
        showCanvas: true,
        showPatches: true,
        showFoundPatches: true,
        showSkeleton: true,
        showLabels: true,
        showPatchLabels: true,
        showRemainingPatchLabels: true,
        boxFromPatches: {
          showTransformed: true,
          showTransformedBox: true,
          showBB: true
        }
      }
    },

  }, function (err) {
    if (err) {
      console.log(err);
      return
    }
    Quagga.start();

    // Set flag to is running
    _scannerIsRunning = true;
  });

  Quagga.onProcessed(function (result) {
    var drawingCtx = Quagga.canvas.ctx.overlay,
        drawingCanvas = Quagga.canvas.dom.overlay;

    if (result) {
      if (result.boxes) {
        drawingCtx.clearRect(0, 0, parseInt(drawingCanvas.getAttribute("width")), parseInt(drawingCanvas.getAttribute("height")));
        result.boxes.filter(function (box) {
          return box !== result.box;
        }).forEach(function (box) {
          Quagga.ImageDebug.drawPath(box, { x: 0, y: 1 }, drawingCtx, { color: "green", lineWidth: 2 });
        });
      }

      if (result.box) {
        Quagga.ImageDebug.drawPath(result.box, { x: 0, y: 1 }, drawingCtx, { color: "#00F", lineWidth: 2 });
      }

      if (result.codeResult && result.codeResult.code) {
        Quagga.ImageDebug.drawPath(result.line, { x: 'x', y: 'y' }, drawingCtx, { color: 'red', lineWidth: 3 });
      }
    }
  });


  Quagga.onDetected(function (result) {

    var scannedBarCode = result.codeResult.code;
    if(!detected) {
      if (scannedBarCode.length > 11) {
        detected = true;
        // _scannerIsRunning = false;
        Quagga.stop();
        $.ajax(
            {
              url: "./scanItem/" + scannedBarCode,
              success: function(result) {
                let list;

                $.ajax(
                    {
                      url: "./getUserHistory",
                      success: function(result) {
                        $("#userHistoryList").innerHTML = "";
                        let values = result;

                        var options = {
                          valueNames: ['itemName', 'type'],
                          item: '<li><h3 class="itemName"></h3><p class="type"></p><p>Points: 1</p></li>'
                        };

                        var hackerList = new List('userHistoryList', options,
                            values);

                      }
                    }
                );

                $(".pane").addClass('hidden');
                $("#history").addClass('frontPane');
                $("#history").removeClass('hidden');
              }
            }
        );
      }
    }
  });

}

function startAndStopScanner() {
      startScanner();
}