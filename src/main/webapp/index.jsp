<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Hệ thống phân công sinh viên báo cáo mỗi kỳ</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="image/logo_ued.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/index.css" rel="stylesheet">
</head>

<body>
    <!-- Spinner Start -->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->
    
   <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light shadow sticky-top p-0">
       <a href="index.jsp" class="navbar-brand d-flex align-items-center px-4 px-lg-5">
       <img src="image/logo_ued.jpg" alt="Logo Đại học SP" height="50">
            <h2 class="m-0 text-primary">ĐH SƯ PHẠM ĐÀ NẴNG</h2>
        </a>
</a>
        </a>
        <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto p-4 p-lg-0">
                <a href="index.jsp" class="nav-item nav-link ">TRANG CHỦ</a>
                <a href="about.jsp" class="nav-item nav-link">GIỚI THIỆU</a>
                <a href="activity.jsp" class="nav-item nav-link">HOẠT ĐỘNG</a>
                <a href="contact.jsp" class="nav-item nav-link">LIÊN HỆ</a>
           </div>
    </nav>
    <!-- Navbar End -->


    <!-- Carousel Start -->
    <div class="container-fluid p-0 mb-5">
        <div class="owl-carousel header-carousel position-relative">
            <div class="owl-carousel-item position-relative">
                <img class="img-fluid" src="image/bgc_ued.jpg" alt="">
                <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center" style="background: rgba(24, 29, 56, .7);">
                    <div class="container">
                        <div class="row justify-content-start">
                            <div class="col-sm-10 col-lg-8">
                                <h5 class="text-primary text-uppercase mb-3 animated slideInDown">ĐẠI HỌC SƯ PHẠM ĐÀ NẴNG</h5>
                                <h1 class="display-3 text-white animated slideInDown">HỆ THỐNG PHÂN CÔNG SINH VIÊN BÁO CÁO CUỐI KỲ</h1>
                                <p class="fs-5 text-white mb-4 pb-2">UED: Dấu ấn của thời gian, niềm tự hào của thế hệ</p>
                          <a href="https://www.facebook.com/khoatinhoc?locale=vi_VN" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft" target="_blank">Khoa Tin Học</a>
<a href="https://www.facebook.com/clbtinhoc.ued?locale=vi_VN" class="btn btn-light py-md-3 px-md-5 animated slideInRight" target="_blank">CLB Tin Học</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="owl-carousel-item position-relative">
                <img class="img-fluid" src="image/bgc2_ued.jpg" alt="">
                <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center" style="background: rgba(24, 29, 56, .7);">
                    <div class="container">
                        <div class="row justify-content-start">
                            <div class="col-sm-10 col-lg-8">
                                <h5 class="text-primary text-uppercase mb-3 animated slideInDown">ĐẠI HỌC SƯ PHẠM ĐÀ NẴNG</h5>
                                <h1 class="display-3 text-white animated slideInDown"> ĐỔI MỚI - HỘI NHẬP - PHÁT TRIỂN BỀN VỮNG</h1>
                                <p class="fs-5 text-white mb-4 pb-2">Gia đình thứ hai, nơi chắp cánh ước mơ!!!</p>
                                <a href="https://www.facebook.com/khoatinhoc?locale=vi_VN" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft" target="_blank">Khoa Tin Học</a>
<a href="https://www.facebook.com/clbtinhoc.ued?locale=vi_VN" class="btn btn-light py-md-3 px-md-5 animated slideInRight" target="_blank">CLB Tin Học</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Carousel End -->
     <!-- About Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="row g-5">
                <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s" style="min-height: 400px;">
                    <div class="position-relative h-100">
                        <img class="img-fluid position-absolute w-100 h-100" src="image/index_ued.jpg" alt="" style="object-fit: cover;">
                    </div>
                </div>
                <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.3s">
                    <h6 class="section-title bg-white text-start text-primary pe-3">Giới thiệu</h6>
                    <h1 class="mb-4">Chào mừng đến với Hệ thống phân công sinh viên báo cáo mỗi kỳ</h1>
                    <p class="mb-4">Trang web cho phép các quản lí khoa có thể phân công giảng viên vào các hội đồng báo cáo cho sinh viên năm 3, năm 4</p>
                    
                    <div class="row gy-2 gx-4 mb-4">
                        <div class="col-sm-6">
                            <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Quản lý Sinh viên</p>
                        </div>
                        <div class="col-sm-6">
                            <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Quản lý Giảng viên</p>
                        </div>
                        <div class="col-sm-6">
                            <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Quản lý Hội đồng</p>
                        </div>
                        <div class="col-sm-6">
                            <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Phân công Giảng viên</p>
                        </div>
                        <div class="col-sm-6">
                            <p class="mb-0"><i class="fa fa-arrow-right text-primary me-2"></i>Quản lý Báo cáo</p>
                        </div>
                        
                    </div>
                    <a class="btn btn-primary py-3 px-5 mt-2" href="">Xem thêm</a>
                </div>
            </div>
        </div>
    </div>
    <!-- About End -->

    






    <!-- Service Start -->
 <!-- Service Start -->
<div class="container-xxl py-5">
    <div class="container">
        <div class="row g-4">
            <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.1s">
                <a href="students.jsp">
                    <div class="service-item text-center pt-3">
                        <div class="p-4">
                            <i class="fa fa-3x fa-graduation-cap text-primary mb-4"></i>
                            <h5 class="mb-3">Quản lý Sinh viên</h5>
                            <p>Cung cấp thông tin sinh viên </p>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.3s">
                <a href="lecturers.jsp">
                    <div class="service-item text-center pt-3">
                        <div class="p-4">
                            <i class="fa fa-3x fa-globe text-primary mb-4"></i>
                            <h5 class="mb-3"> Quản lý Giảng viên</h5>
                            <p>Cung cấp thông tin giảng viên</p>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.5s">
                <a href="committees.jsp">
                    <div class="service-item text-center pt-3">
                        <div class="p-4">
                            <i class="fa fa-3x fa-home text-primary mb-4"></i>
                            <h5 class="mb-3">Quản lý Hội đồng</h5>
                            <p>Cung cấp thông tin hội đồng</p>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.7s">
                <a href="assignments.jsp">
                    <div class="service-item text-center pt-3">
                        <div class="p-4">
                            <i class="fa fa-3x fa-book-open text-primary mb-4"></i>
                            <h5 class="mb-3">Phân công Giảng viên</h5>
                            <p>Cung cấp thông tin phân công giảng viên vào các hội đồng khác nhau</p>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-lg-3 col-sm-6 wow fadeInUp" data-wow-delay="0.7s">
                <a href="reports.jsp">
                    <div class="service-item text-center pt-3">
                        <div class="p-4">
                            <i class="fa fa-3x fa-book-open text-primary mb-4"></i>
                            <h5 class="mb-3">Quản lý Báo cáo</h5>
                            <p>Cung cấp thông tin đề tài báo cáo của sinh viên</p>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>
<!-- Service End -->
    


   


    <!-- Categories Start -->
    <div class="container-xxl py-5 category">
        <div class="container">
            <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                <h6 class="section-title bg-white text-center text-primary px-3">Hoạt động </h6>
                <h1 class="mb-5">Hoạt động mới</h1>
            </div>
            <div class="row g-3">
                <div class="col-lg-7 col-md-6">
                    <div class="row g-3">
                        <div class="col-lg-12 col-md-12 wow zoomIn" data-wow-delay="0.1s">
                            <a class="position-relative d-block overflow-hidden" href="">
                                <img class="img-fluid" src="image/ảnh 2 _ued.jpg" alt="">
                                <div class="bg-white text-center position-absolute bottom-0 end-0 py-2 px-3" style="margin: 1px;">
                                    <h5 class="m-0">Công trình văn hoá</h5>
                                    
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-6 col-md-12 wow zoomIn" data-wow-delay="0.3s">
                            <a class="position-relative d-block overflow-hidden" href="">
                                <img class="img-fluid" src="image/nhagiao.jpg" alt="">
                                <div class="bg-white text-center position-absolute bottom-0 end-0 py-2 px-3" style="margin: 1px;">
                                    <h5 class="m-0">Nhà Giáo Việt Nam</h5>
                                   
                                </div>
                            </a>
                        </div>
                        <div class="col-lg-6 col-md-12 wow zoomIn" data-wow-delay="0.5s">
                            <a class="position-relative d-block overflow-hidden" href="">
                                <img class="img-fluid" src="image/taphuan.jpg" alt="">
                                <div class="bg-white text-center position-absolute bottom-0 end-0 py-2 px-3" style="margin: 1px;">
                                    <h5 class="m-0">Tập huấn</h5>
                              
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5 col-md-6 wow zoomIn" data-wow-delay="0.7s" style="min-height: 50px;">
                    <a class="position-relative d-block h-100 overflow-hidden" href="">
                        <img class="img-fluid position-absolute w-100 h-100" src="image/ngaysach.jpg" alt="" style="object-fit: cover;">
                        <div class="bg-white text-center position-absolute bottom-0 end-0 py-2 px-3" style="margin:  1px;">
                            <h5 class="m-0">Ngày sách Việt Nam</h5>
                        
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <!-- Categories Start -->


    <!-- Courses Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                <h6 class="section-title bg-white text-center text-primary px-3">Khoa Tin Học</h6>
                <h1 class="mb-5">Câu lạc Bộ Tin Học </h1>
            </div>
            <div class="row g-4 justify-content-center">
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="course-item bg-light">
                        <div class="position-relative overflow-hidden">
                            <img class="img-fluid" src="image/clb_1.jpg" alt="">
                            
                        </div>
                        <div class="text-center p-4 pb-0">
                           
                            <h5 class="mb-4">Chào đón TSV</h5>
                        </div>
                       
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                    <div class="course-item bg-light">
                        <div class="position-relative overflow-hidden">
                            <img class="img-fluid" src="image/clb_2.jpg" alt="">
                           
                        </div>
                        <div class="text-center p-4 pb-0">
                            
                          
                            <h5 class="mb-4">Hoạt động ngoại khoá </h5>
                        </div>
                       
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="course-item bg-light">
                        <div class="position-relative overflow-hidden">
                            <img class="img-fluid" src="image/clntinhoc.jpg" alt="">
                            
                        </div>
                        <div class="text-center p-4 pb-0">
                            
                            <h5 class="mb-4">Thành viên CLB 2024</h5>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Courses End -->


    

   
        

    <!-- Footer Start -->
    <div class="container-fluid bg-dark text-light footer pt-5 mt-5 wow fadeIn" data-wow-delay="0.1s">
        <div class="container py-5">
            <div class="row g-5">
              
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Liên hệ</h4>
                    <p class="mb-2"><i class="fa fa-map-marker-alt me-3"></i>459 Tôn Đức Thắng, Hoà Khánh Nam, Liên Chiểu, Đà Nẵng 550000</p>
                    <p class="mb-2"><i class="fa fa-phone-alt me-3"></i> 0236 3841 323</p>
                    <p class="mb-2"><i class="fa fa-envelope me-3"></i>ued@udn.com</p>
                    <div class="d-flex pt-2">
                        
                        <a class="btn btn-outline-light btn-social" href="https://www.facebook.com/khoatinhoc?locale=vi_VN"><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-outline-light btn-social" href="https://www.youtube.com/@UEDTV"><i class="fab fa-youtube"></i></a>
                   
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Nổi bật</h4>
                    <div class="row g-2 pt-2">
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="image/clb_4.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="image/clb_5.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="image/clb_6.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="image/clb_7.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="image/clb_8.jpg" alt="">
                        </div>
                        <div class="col-4">
                            <img class="img-fluid bg-light p-1" src="image/clb_9.jpg" alt="">
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="text-white mb-3">Đóng góp </h4>
                    <p>Vui lòng liên hệ nếu bạn có ý kiến</p>
                    <div class="position-relative mx-auto" style="max-width: 400px;">
                        <input class="form-control border-0 w-100 py-3 ps-4 pe-5" type="text" placeholder="Email của bạn">
                        <button type="button" class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">Đăng nhập</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="copyright">
                <div class="row">
                    <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                        &copy; <a class="border-bottom" href="https://ued.udn.vn/">ĐẠI HỌC SƯ PHẠM ĐÀ NẴNG</a>, All Right Reserved.

                        
                    </div>
                   
                </div>
            </div>
        </div>
    </div>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="Js/main.js"></script>
</body>

</html>