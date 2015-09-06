# java-ee-7-example

container profile:
Wildfly 9.0.0.Final  
  
database: MySQL  
  
Module Java EE yang diguanakan:  
JAX-RS: untuk rest api  
CDI   : digunakan untuk inject data-data cart  
JPA   : ORM untuk konek ke mysql  
        menggunakan implementation: hiberante  
        menggunakan cache provider: infinispan  
EJB   : digunakan untuk menjadikan class jax-rs mempunyai scope transaction  
Validation: digunakan untuk validasi model yang ada 
  
structure folder:  
java  
    |_ bean : package untuk menampung model-model diluar model database dan dto  
    |_ config: package untuk menaru class2 konfigurasi  
    |_ dto: package untuk class Data Transfer Object  
    |_ entity: package untuk semua class yang di map ke table di database  
    |_ listener: package untuk menaru class2 listener.  
    |_ resource: package untuk class rest api  
resource  
    |_ META-INF: folder untuk meletakan persistence.xml  
webapp  
    |_ bower_components: folder vendor2 framework client side  
    |_ component: folder tempat component2 yang digunakan angular  
                  terdapat file html, controller dan service dengan convetion sebagai berikut:  
                  misal: nama component productDetail  
                  maka di folder product akan terdapat: productDetail.html, productDetailController.js, [productService.js]  
    |_ js: folder tempat javascript  
    