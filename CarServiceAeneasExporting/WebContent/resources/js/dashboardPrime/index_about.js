$('.owl-carousel').owlCarousel({
    loop:true,
      margin:5,
      nav:true,
      navText:[
          '<span aria-label="Previous"><i class="fas fa-chevron-circle-left"></i></span>','<span aria-label="Next"><i class="fas fa-chevron-circle-right"></i></span>'
        ],
     responsive:{
         0:{
        items:1,
        nav:false
         },
      600:{
          items:2,
          nav:false
        },
        1000:{
          items:3,
          nav:false
    },
    1200:
    {
       items:4
    }
            }
        });




        $(document).ready(function(){
            let featuresOffset  = $("#body-about").offset().top;
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





             var acc = document.getElementsByClassName("accordion");
             var i;
             
             for (i = 0; i < acc.length; i++) {
               acc[i].addEventListener("click", function() {
                 this.classList.toggle("active");
                 var panel = this.nextElementSibling;
                 if (panel.style.maxHeight) {
                   panel.style.maxHeight = null;
                 } else {
                   panel.style.maxHeight = panel.scrollHeight + "px";
                 }
               });
             }