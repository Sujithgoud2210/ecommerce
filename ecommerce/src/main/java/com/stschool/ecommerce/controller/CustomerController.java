package com.stschool.ecommerce.controller;

public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) throws IOException {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    //api/v1/customers/10
    public ResponseEntity<?> getCustomerById(@PathVariable int id)  {
        try {
            return ResponseEntity.ok(customerService.getById(id));
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    public Customer getCustomerByEmail(String email) throws CustomerNotFoundException {
        return customerService.getByEmail(email);
    }

    public Customer updateCustomer(Customer customer) throws Exception {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/")
    //api/v1/customers?id=1
    public void deleteCustomer(@RequestParam("id") int id) throws Exception {
        customerService.deleteCustomer(id);
    }
}
