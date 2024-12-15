const images = ['blog4.jpg', 'you.jpg', 'blog3.jpg', 'home-page.jpg'];
images.forEach((src) => {
    const img = new Image();
    img.src = src; // Preload the images
});
const swiper = new Swiper('.swiper', {
   autoplay: {
    delay: 2000,
    disableOnInteraction : false,
   },
    loop: true,
  
    
    pagination: {
      el: '.swiper-pagination',
      clickable:true,
    },
  
   
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
  
    
   
  });





