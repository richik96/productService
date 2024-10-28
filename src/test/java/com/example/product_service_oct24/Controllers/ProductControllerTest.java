package com.example.product_service_oct24.Controllers;

//@SpringBootTest
//class ProductControllerTest {
//
//    @Autowired
//    private ProductController productController;    //injecting the controller
//
//    @MockBean
//    private SelfProductService productService;  //mocking the service
//
//    @MockBean
//    private ProductRepository productRepository;  //mocking the repository
//
//    @Test
//    void testProductsSameAsService() {
//        //Arrange
//        List<Product> products = new ArrayList<>();
//        Product p1 = new Product();
//        p1.setTitle("iPhone16");
//        p1.setDescription("Best phone");
//        products.add(p1);
//
//        Product p2 = new Product();
//        p1.setTitle("iPhone15");
//        p1.setDescription("Best phone");
//        products.add(p2);
//
//        Product p3 = new Product();
//        p1.setTitle("iPhone13");
//        p1.setDescription("Best phone");
//        products.add(p3);
//        when(
//                productService.getAllProducts()
//        ).thenReturn(
//                products
//        );

        //Act
        //ResponseEntity<List<Product>> response =  productController.getAllProducts();

        //Assert
        //List<Product> productResponse = response.getBody();

        //assertEquals(products.size(), productResponse.size());
  //  }



//    @Test
//    void testnonExistingProductthowsException() throws ProductNotExistsException {
//
//        //Arrange
//        when(
//                productRepository.findById(1L))
//                .thenReturn(
//                        Optional.empty()
//                );
//
//        when(
//                productService.getSingleProduct(10L)
//        ).thenCallRealMethod();
//


        //Act
//        assertThrows(
//                ProductNotExistsException.class,
//                () -> productController.getSingleProduct(10L)
//        );
 //   }
//}