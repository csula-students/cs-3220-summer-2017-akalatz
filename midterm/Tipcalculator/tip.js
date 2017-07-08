var $=function(id)
{
  return document.getElementById(id);
}

var calculateClick = function()
{
  var billamt=parseFloat($("billamt").value);
  var percenttip=parseFloat($("percenttip").value);

  var tip=billamt*(percenttip/100);
  var total=tip+billamt;
  $("tip").value=tip.toFixed(2);
  $("totalTip").value=total.toFixed(2);
}

window.onload=function()
{
  $("calculate").onclick=calculateClick;
  $("billamt").focus();
}                        
