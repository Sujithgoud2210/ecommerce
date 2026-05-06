package com.stschool.ecommerce.repository;

@Repository
public class ProductRepository {
    /*
    CRUD operations on Products
     */
    private final List<Product> products;


    public ProductRepository()  {
        products = new ArrayList<>();
    }

    public Product save(Product product) {
        this.products.add(product);
        return product;
    }

    public Optional<Product> findById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }

    public List<Product> findAll(){
        return this.products;
    }

    public Product update(int id, Product product) {
        products.replaceAll(p -> p.getId() == id ? product : p);
        return product;
    }

    public boolean delete(int id) {
        return products.removeIf(product -> product.getId() == id);
    }

    public boolean delete(Product product){
        return products.remove(product);
    }



}
