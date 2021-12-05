/**
 * Created by Malal91 and Haziel
 * Select multiple email by jquery.email_multiple
 * **/

(function($){

    $.fn.email_multiple = function(options) {

        let defaults = {
            reset: false,
            fill: false,
            data: null
        };

        let settings = $.extend(defaults, options);
        let email = "";

        return this.each(function()
        {
            $(this).after("<span class=\"to-input\"></span>\n" +
                "<div class=\"all-mail\"></div>\n" +
                "<input type=\"text\" name=\"email\" class=\"enter-mail-id\" placeholder=\"Enter Email ...\" />");
            let $orig = $(this);
            let $element = $('.enter-mail-id');
            $element.keydown(function (e) {
                $element.css('border', '');
                if (e.keyCode === 13 || e.keyCode === 32) {
                    let getValue = $element.val();
                    if (/^[a-z0-9._-]+@[a-z0-9._-]+\.[a-z]{2,6}$/.test(getValue)){
                    	if(!isElementExist(email,getValue)){
                        $('.all-mail').append('<span class="email-ids" >' + '<span class="valueMail">'+getValue+'</span>' + '<span class="cancel-email">x</span></span>');
                        $element.val('');

                        email += getValue + ';'
                        $orig.val(email);
                    	}else{
                    		 $element.css('border', '1px solid red')
                    	}
                    	} else {
                        $element.css('border', '1px solid red')
                    }
                }

               // $orig.val(email.slice(0, -1))
            });

            $(document).on('click','.cancel-email',function(){
                $(this).parent().remove();
                
                	let selement=$(this).parent().find('span.valueMail')[0].innerHTML;
                	var defData = email;
                    let sData=defData.toString();
	                let dataArray=sData.split(";");
                    //alert(dataArray);
	                let newArray=removeElementFromArray(dataArray,selement);
	                if(newArray.length>1){
	                	var returnedString = newArray[0];
	                	for(var i=1;i<newArray.length;i++){
	                		returnedString += ';' + newArray[i] 
	                	}
	                	email = returnedString;
		                $orig.val(email);
	                }else{

		                //alert(newArray);
	                	email = newArray;
		                $orig.val(email);
	                }
	                settings.data=newArray;
	              });

            function isElementExist(arrayOfEmails,element){
            	
	                let dataArray=arrayOfEmails.split(";");
            	for( var i = 0; i < dataArray.length; i++){ 
            		   if ( dataArray[i] == element) {
            			return true;
            		   }
            		}
            	return false;
            	
            }
            
            function removeElementFromArray(dataArray,element){
            	let newArray = [];
            	for( var i = 0; i < dataArray.length; i++){ 
            		   if ( dataArray[i] != element) {
            			newArray.push(dataArray[i]);
            		   }
            		}
            	return newArray;
            	
            }
            
            
            if(settings.data){
                $.each(settings.data, function (x, y) {
                    if (/^[a-z0-9._-]+@[a-z0-9._-]+\.[a-z]{2,6}$/.test(y)){
                        $('.all-mail').append('<span class="email-ids">' + '<span class="valueMail">'+y+'</span>' + '<span class="cancel-email">x</span></span>');
                        $element.val('');

                        email += y + ';'
                    } else {
                        $element.css('border', '1px solid red')
                    }
                })

               // $orig.val(email.slice(0, -1))
            }

            if(settings.reset){
                $('.email-ids').remove()
            }

            return $orig.hide()
        });
    };

})(jQuery);
