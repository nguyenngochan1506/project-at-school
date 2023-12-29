

window.addEventListener('load', ()=>{
    //phần hiển thị biểu mẫu
    document.querySelector('#bieu-mau').addEventListener('click', ()=>showBieuMau());//hiện
    document.querySelector('#icon-close').addEventListener('click', ()=>closeBieuMau());//ẩn
    //phần theme sáng tối
    const myToggle = document.querySelector('.toggle-theme');
    myToggle.addEventListener('click', ()=>changeTheme(myToggle));
})
const changeTheme = (myToggle)=>{
   if(myToggle.classList.toggle('bi-moon-fill')){
    myToggle.style.color = 'white'
    document.querySelector('.my-header').classList.add('dark-header');
    document.querySelector('.my-header img').classList.add('dark-header');
    document.querySelector('.my-header img').setAttribute('src', './images/dark-logo.png')
    document.querySelector('.btn-login').classList.add('dark-header-login')
    document.querySelector('.btn-signup').classList.add('dark-header-sigup')
    document.querySelector('body').classList.add('my-content-dark')
    document.querySelector('.my-footer').classList.add('footer-dark-mode')
    document.querySelector('.btn-load-more').classList.add('btn-load-more-dark-mode')

   }else{
    myToggle.style.color = 'black'
    document.querySelector('.my-header').classList.remove('dark-header');
    document.querySelector('.my-header img').classList.remove('dark-header');
    document.querySelector('.my-header img').setAttribute('src', './images/logo-lab-07.png')
    document.querySelector('.btn-login').classList.remove('dark-header-login')
    document.querySelector('.btn-signup').classList.remove('dark-header-sigup')
    document.querySelector('body').classList.remove('my-content-dark')
    document.querySelector('.my-footer').classList.remove('footer-dark-mode')
    document.querySelector('.btn-load-more').classList.remove('btn-load-more-dark-mode')
   }
}
const showBieuMau = ()=>{
    document.querySelector('.popup-bieu-mau').classList.remove('close-popup');
}
const closeBieuMau = ()=>{
    document.querySelector('.popup-bieu-mau').classList.add('close-popup');
}
