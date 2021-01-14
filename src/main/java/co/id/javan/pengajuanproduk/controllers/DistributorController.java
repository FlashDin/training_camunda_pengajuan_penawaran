package co.id.javan.pengajuanproduk.controllers;

import co.id.javan.pengajuanproduk.pojo.Distributor;
import co.id.javan.pengajuanproduk.repositories.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task/distributor")
public class DistributorController {

    @Autowired
    private DistributorRepository distributorRepository;

    @GetMapping(path = "/db/all")
    public List<Distributor> findAll() {
        return distributorRepository.findAll();
    }

    @GetMapping(path = "/db/{id}")
    public Distributor findById(@PathVariable long id) {
        return distributorRepository.findById(id).get();
    }

}
