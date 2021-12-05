var eventKey;

function registerSubmitHandlers() {
    if (typeof (autoSubmitNames) != "undefined") {
        for (i = 0; i < autoSubmitNames.length; i++) {
            var ob = $("[id$='" + autoSubmitNames[i] + "']")[0];

            if (ob != null)
                ob.onkeydown = doSubmit;
        }
        if (!document.all) {
            eventKey = "e.keyCode";
            document.captureEvents(Event.KeyDown);
        }
        else
            eventKey = "event.keyCode";
    }
}

function doSubmit(e) {
    if (eval(eventKey) == 13) {
        for (i = 0; i < autoSubmitNames.length; i++) {
            if (autoSubmitNames[i] == this.id) {
                eval(autoSubmit[i]);
                return false;
            }
        }
    }
}

// HACK: we should have only one popup at time
var BubblePopup;

function showBubblePopup(button, url, onSuccess) {

    button = button.parentNode;

    if (BubblePopup != null) {
        BubblePopup.HideBubblePopup();
    }

    BubblePopup = $(button);
    
    if (BubblePopup.HasBubblePopup()) {
        BubblePopup.ShowBubblePopup();
        BubblePopup.FreezeBubblePopup();
    } else {

        var options = {
            width: '200px',
            innerHtml: '<img src="../images/loading.gif" style="border:0px; vertical-align:middle; margin-right:10px; display:inline;" />loading!',
            themeName: 'all-blue',
            themePath: '../jquerybubblepopup-theme',
            selectable: true,
            openingSpeed: 0,
            align: 'middle',
            position: 'left',
            manageMouseEvents: false
        };

        BubblePopup.CreateBubblePopup(options);
        BubblePopup.ShowBubblePopup();
        BubblePopup.FreezeBubblePopup();

        $.ajax({
            url: url,
            dataType: 'json',
            success: onSuccess,
            context: button,
            async: true      
        });
    }
}

// TODO: move to page specific script file
function showVehicleQuickView(bookingId, button) {
    showBubblePopup(button, 'Services/BookingQuery.ashx?id=' + bookingId, onShowVehicleQuickView);
}

function onShowVehicleQuickView(data) {
    // TODO: make jQuery.Template
    var result = [];

    if (data.count > 0) {

        for (i = 0; i < data.items.length; i++) {
            var item = data.items[i];

            if (i > 0) {
                result.push('<br/>');
            }
            // TODO: move styles to css
            result.push('<table style="font-size: 13px; color: white; font-family: tahoma">');
            result.push('<tr><td style="width: 79px">' + 'Booking #:');
            result.push('</td><td style="width: 113px">' + item.BookingNumber + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'Commodity:');
            result.push('</td><td style="width: 113px">' + item.Commodity + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'Equipment:');
            result.push('</td><td style="width: 113px">' + item.Equipment + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'Inventory Type:');
            result.push('</td><td style="width: 113px">' + item.InventoryType + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'Carrier:');
            result.push('</td><td style="width: 113px">' + item.Carrier + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'Vessel:');
            result.push('</td><td style="width: 113px">' + item.Vessel + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'Voyage #:');
            result.push('</td><td style="width: 113px">' + item.VoyageNumber + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'Port Of Export:');
            result.push('</td><td style="width: 113px">' + item.PortOfExport + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'TransShip:');
            result.push('</td><td style="width: 113px">' + item.TransShip + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'Container Location:');
            result.push('</td><td style="width: 113px">' + item.ContainerLocation + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'Pickup Location:');
            result.push('</td><td style="width: 113px">' + item.PickupLocation + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'Return Location:');
            result.push('</td><td style="width: 113px">' + item.ReturnLocation + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'First Receiving Date:');
            result.push('</td><td style="width: 113px">' + item.FirstReceivingDate + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'Seal #:');
            result.push('</td><td style="width: 113px">' + item.SealNumber + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'IN-GATE:');
            result.push('</td><td style="width: 113px">' + item.InGate + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'Last Day Free:');
            result.push('</td><td style="width: 113px">' + item.LastDayFree + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'First Pickup Date:');
            result.push('</td><td style="width: 113px">' + item.FirstPickupDate + '</td></tr>');
            result.push('<tr><td style="width: 79px">' + 'Shipping Line:');
            result.push('</td><td style="width: 113px">' + item.ShippingLine + '</td></tr>');
            result.push('</table>');
        }

    } else {
        result.push('<div>No Data</div>');
    }

    $(this).SetBubblePopupInnerHtml(result.join(''));
}

function showFreightList(id, button) {
    showBubblePopup(button, 'Services/VehicleQuery.ashx?id=' + id, onShowFreightList);
}

function onShowFreightList(data) {

    var result = [];

    if (data.count > 0) {
    
        for (i = 0; i < data.items.length; i++) {
            var item = data.items[i];
            
            if(i > 0){
                 result.push('<br/>');
            }

            result.push('<div><a href="viiEdit.aspx?ID=', item.vehicleId, '&Mode=select">UID:', item.UID, '</a></div>');
            result.push('<div>Client:', item.ClientName, '</div>');
            result.push('<div>Consignee:', item.ConsigneeName, '</div>');
        }

    } else {
        result.push('<div>No Freight</div>');
    }

    $(this).SetBubblePopupInnerHtml(result.join(''));
}

function wait(msecs) {
    var start = new Date().getTime();
    var cur = start
    while (cur - start < msecs) {
        cur = new Date().getTime();
    }
} 

function cutString(obj, count) {
    str = obj.value;
    strlen = str.length;
    if (strlen > count) obj.value = str.substring(0, count - 1);
}

function CheckSave(strURL) {
    if ($('input[id$=hdIsChanged]').val() == "1") {
        if (confirm("Would you like to exit without saving changed data? If no press cancel and save your changes then exit.")) {
            window.location = strURL;
        }
    }
    else {
        window.location = strURL;
    }
}

function SetIsChanged() {
    $('input[id$=hdIsChanged]').val('1');
}

$(document).ready(function() {
    //protect changes from navigation
    $('.mn-sub a, .mn-main a').click(OnProtectedNavigation); 
});

function OnProtectedNavigation() {

    if ($('input[id$=hdIsChanged]').val() == '1') {

        if (confirm("Would you like to exit without saving changed data? If no press cancel and save your changes then exit.")) {
            return true;
        }
        
        return false;
    }
    
    return true;
}

function IntField2(field) {
    if (isNaN(field.value)) {
        alert("Incorrect Number!");
        field.value = "0";
        return false;
    }
}

function upperCaseField(id) {
    $('#' + id).bestupper(); 
    //$('#' + id).keyup(function () {
        //this.value = this.value.toUpperCase();
    //});
}

(function ($) {
    $.fn.bestupper = function (settings) {
        var defaults = { ln: 'en', clear: true },
            settings = $.extend({}, defaults, settings);

        this.each(function () {
            var $this = $(this);
            if ($this.is('textarea') || $this.is('input:text')) {
                $this.keypress(function (e) {
                    var pressedKey = e.charCode == undefined ? e.keyCode : e.charCode; 
                    var str = String.fromCharCode(pressedKey);
                    if (pressedKey < 97 || pressedKey > 122) {
                        if (settings.ln == 'en' || !isTRChar(pressedKey)) return;
                    }
                    if (settings.ln == 'tr' && pressedKey == 105) str = '\u0130'; 
                    if (this.createTextRange) {
                        window.event.keyCode = str.toUpperCase().charCodeAt(0); return;
                    }
                    else {
                        var startpos = this.selectionStart; var endpos = this.selectionEnd;
                        this.value = this.value.substr(0, startpos) + str.toUpperCase() + this.value.substr(endpos);
                        this.setSelectionRange(startpos + 1, startpos + 1); return false;
                    } 
                });
                if (settings.clear) {
                    $this.blur(function (e) {
                        if (settings.ln == 'tr') this.value = this.value.replace(/i/g, "\u0130");
                        this.value = this.value.replace(/^\s+|\s+$/g, "").replace(/\s{2,}/g, " ").toUpperCase();
                    });
                } 
            } 
        });
    };
    function isTRChar(key) {
        var trchar = [231, 246, 252, 287, 305, 351];
        for (var i = 0; i < trchar.length; i++) { if (trchar[i] == key) return true; } return false;
    }
})(jQuery);



function IntField(field) {
    if (isNaN(field.value)) {
        alert("Incorrect Number!");

        field.value = "0";
        return false;
    }
    try {
        var num = new Number(field.value);

        if (num > 2147483647 || num < 0) {
            alert("Incorrect Number!");
            field.value = "0";
            return false;
        }
        else {
            field.value = num.toFixed(0);
            return true;
        }
    }
    catch (ex) {
        alert("Incorrect Number!");
        field.value = "0";
        return false;
    }
}

function SetDdlValueToHidden(name, id) {
    var input = $('input[id$=h' + name + ']');
    input.val(id);
}

function SetDdlValueToHiddenN(name, id) {
    var input = $('input[id$=' + name + ']');
    input.val(id);
}

function OpenFilter(strObj) {
    if (strObj == "Destination") {
        window.open('DestinationFilter.aspx', 'Filter', 'width =600,height =600,menubar=no,top=50,left=50, scrollbars=yes,status=yes,toolbar=no,resizable=yes, scrollbars=yes');
    }
    else
        window.open('Filter.aspx?Object_Type=' + strObj, 'Filter', 'width =600,height =600,menubar=no,top=50,left=50, scrollbars=yes,status=yes,toolbar=no,resizable=yes, scrollbars=yes');
}

function OpenFilterEx(strObj, ControlName, hControlName) {
    if (strObj == "Destination") {
        window.open('DestinationFilter.aspx?ControlName=' + ControlName + '&hControlName=' + hControlName, 'Filter', 'width =600,height =600,menubar=no,top=50,left=50, scrollbars=yes,status=yes,toolbar=no,resizable=yes, scrollbars=yes');
    }
    else
        window.open('Filter.aspx?Object_Type=' + strObj + '&ControlName=' + ControlName + '&hControlName=' + hControlName, 'Filter', 'width =600,height =600,menubar=no,top=50,left=50, scrollbars=yes,status=yes,toolbar=no,resizable=yes, scrollbars=yes');
}

function GetCurrentTime() {
    var currentDate = new Date();
    var currentHours = currentDate.getHours();
    var currentMinutes = currentDate.getMinutes();
    var strAmPm = 'AM';

    if (currentHours >= 12) {
        strAmPm = 'PM';
    }

    if (currentHours > 12) {
        currentHours = currentHours - 12;
    }

    return (currentHours + ':' + currentMinutes + ' ' + strAmPm);
}

function CheckZip(zip) {
    var zipTemplate = new RegExp("^[0-9A-Za-z-]+$");

    if (zip == '')
        return '';

    if (!zipTemplate.test(zip)) {
        alert('Invalid ZIP! Zip code may include only characters and "-" symbol.');
        return '';
    }

    if (zip.length > 10) {
        alert('Invalid ZIP! Zip code should include only 10 characters or less.');
        return '';
    }
    return zip;
}

function ViewDocById(strID) {
    if (strID != '-1') {
    	window.open('/images/?file='+strID,'Image', 'width=850,height=900,scrollbars=yes,resizable=yes');
    }
}

function ViewPDFById(strID) {
    if (strID != '-1') {
    	window.open('/images/?file='+strID+'&Pdf=1','_blank', 'fullscreen=yes');
    }
}

function ChangeVisibillity(strPanelName, strImgLinkName) {
    var divControl = window.document.all[strPanelName];
    var imgLink = window.document.all[strImgLinkName];

    if (divControl.style.display == "inline") {
        divControl.style.display = "none";
        imgLink.src = "/resources/images/img/accordeon_close.png";
    }
    else {
        divControl.style.display = "inline";
        imgLink.src = "/resources/images/img/accordeon_open.png";
    }
}

function confirmObjectDelete(obj) {
    var agree = confirm("Are you sure you want to delete this " + obj + "?");
    if (agree)
        return true;
    else
        return false;
}

// function used for conditional date validation 
function checkDateTextBox(textField, butView, inputFile) {
    var txtToCheck = $('input[id$=' + textField + ']')[0];
    var inputDate = txtToCheck.value;

    var reg = new RegExp('^(0[1-9]|1[012]|[1-9])[/](0[1-9]|[12][0-9]|3[01]|[1-9])[/](19|20)\\d\\d(.)*$');
    if (butView == null && inputFile == null) {
        if (!inputDate.match(reg)) {
            alert('Please enter valid date');
            txtToCheck.focus();
            return false;
        }
    }

    var btnView = $('[id$=' + butView + ']')[0];
    var inpFile = $('[id$=' + inputFile + ']')[0];

    if (!(inputDate.match(reg) || (btnView == null && inpFile.value == ''))) {
        alert('Please enter valid date');
        txtToCheck.focus();
        return false;
    }
    return true;
}

function SetDateSimple(txtControlID) {

    var txtControl = $('input[id$=' + txtControlID + ' ]')[0];

    if (txtControl != null) {
        var D = new Date;
        var M = D.getMonth() + 1;
        txtControl.value = M + '/' + D.getDate() + '/' + D.getFullYear();
    }
}

function SetDate(txtControlID, chkControlID, needToDisable) {
    var txtControl = $('input[id$=' + txtControlID + ' ]')[0];
    var chkControl = $('input[id$=' + chkControlID + ' ]')[0];

    if (chkControl.checked) {
        SetDateSimple(txtControlID);
        if (needToDisable == 'true')
            txtControl.disabled = false;
    }
    else {
        txtControl.value = "";
        if (needToDisable == 'true')
            txtControl.disabled = true;
    }
}

function SetDateTime(txtControlID, chkControlID) {
    var txtControl = $('input[id$="' + txtControlID + '"]')[0];
    var chkControl = $('input[id$="' + chkControlID + '"]')[0];

    if (chkControl.checked)
        txtControl.value = GetDateTimeString(new Date);
    else
        txtControl.value = "";
}

function GetDateTimeString(selectedDate) {
    var M = selectedDate.getMonth() + 1;
    var H = selectedDate.getHours();
    var mm = selectedDate.getMinutes();
    var AMPM = 'AM';

    if (H > 12) { H = H - 12; AMPM = 'PM'; }
    if (mm < 10) mm = '0' + mm;

    return M + '/' + selectedDate.getDate() + '/' + selectedDate.getFullYear() + ' ' + H + ':' + mm + ' ' + AMPM;
}

function SetTwoDates(txtControlID1, txtControlID2, chkControlID) {

    var txtControl1 = $('input[id$=' + txtControlID1 + ']')[0];
    var txtControl2 = $('input[id$=' + txtControlID2 + ']')[0];
    var chkControl = $('input[id$=' + chkControlID + ']')[0];

    if (chkControl.checked) {
        var D = new Date;
        var M = D.getMonth() + 1;
        txtControl1.value = M - 1 + '/' + D.getDate() + '/' + D.getFullYear();
        txtControl2.value = M + '/' + D.getDate() + '/' + D.getFullYear();
        txtControl1.disabled = false;
        txtControl2.disabled = false;
    }
    else {
        txtControl1.value = "";
        txtControl1.disabled = true;
        txtControl2.value = "";
        txtControl2.disabled = true;
    }
}

function ViewDoc_General(id) {
    if (id != '-1') {
        window.open('viewDoc.aspx?Document_ID=' + id, 'viewDoc', 'width=850,height=900,scrollbars=yes,resizable=yes');
    }
}
