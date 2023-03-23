package edu.iu.c322.customerservice.controller;

import edu.iu.c322.customerservice.model.Customer;
import edu.iu.c322.customerservice.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository){
        this.repository = repository;
    }


    // sends localhost:8080/customers
    @GetMapping()
    public List<Customer> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public int create(@Valid @RequestBody Customer customer){
        return repository.create(customer);
    }



//    Put Localhost:8080/customers handled by this method
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Customer customer, @PathVariable int id){
        repository.update(customer, id);
    }

    @DeleteMapping("/{id}")
    public  void delete(@PathVariable int id){
        repository.delete(id);
    }
}
