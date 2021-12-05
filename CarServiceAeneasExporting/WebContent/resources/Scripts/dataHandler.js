var URLCopartImages="https://www.copart.com/public/data/lotdetails/solr/lotImages/";
var URLCopartVin="https://www.copart.com/g2mext/public/lot/epic-vin/";
var URLCopartData="https://www.copart.com/public/data/lotdetails/solr/lotImages/";
var URLCopartURL="https://www.copart.com/lot/";




//Create the XHR object.
function createCORSRequest(method, url) {
var xhr = new XMLHttpRequest();
if ("withCredentials" in xhr) {
 // XHR for Chrome/Firefox/Opera/Safari.
 xhr.open(method, url, true);
} else if (typeof XDomainRequest != "undefined") {
 // XDomainRequest for IE.
 xhr = new XDomainRequest();
 xhr.open(method, url);
} else {
 // CORS not supported.
 xhr = null;
	console.log("Error");
 hideDialog();
 ErrorDialog();
}
return xhr;
}



//Make the actual CORS request.
function makeCorsRequest(urlOfRequest,funcCommand,data) {
// This is a sample server that supports CORS.
var url = urlOfRequest;

var xhr = createCORSRequest('GET', url);
if (!xhr) {
	hideDialog();
	console.log("Error");
	ErrorDialog();
	return 'CORS not supported';
}

// Response handlers.
xhr.onload = function() {
 var text = xhr.responseText;
 funcCommand(text,data);
 return text;
};

xhr.onerror = function() {
	hideDialog();
	console.log("Error");
	ErrorDialog();
 return 'Woops, there was an error making the request.';
};

xhr.send();
}

