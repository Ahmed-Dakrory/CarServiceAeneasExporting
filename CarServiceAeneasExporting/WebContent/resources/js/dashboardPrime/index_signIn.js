


        $(document).ready(function(){
            let featuresOffset  = $("#body-contact").offset().top;
            $(window).scroll(function () {  
                let wScroll=  $(window).scrollTop();
                if(wScroll >  featuresOffset-50)
                {
                 $("#btnUp").fadeIn(500);
                 $("#navbar").css("backgroundColor","rgb(32, 32, 32)");
                }
                else
                {
                 $("#btnUp").fadeOut(500);
                 $("#navbar").css("backgroundColor","transparent");
             
                }
                 
             })
             
             $("#btnUp").click(function(){
             
                 $("html,body").animate( {scrollTop:'0'}, 1000)
             })
 
             $(".nav a").click(function(){
 
                 let aHref =  $(this).attr("href");//#service#menu
             
                 let sectionOffset  = $(aHref).offset().top;
             
                 $("html,body").animate( {scrollTop:sectionOffset}, 1000);
             
             });
        
            
                 $("#loading").slideUp(2000 , function(){
             
                     $("body").css("overflow","auto")
                 });
             })