package co.id.javan.pengajuanproduk.controllers;

import co.id.javan.pengajuanproduk.pojo.Distributor;
import co.id.javan.pengajuanproduk.repositories.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    @PostMapping(path = "/db")
//    public Map<String, Object> save(@RequestBody Distributor distributor) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("msg", "Data berhasil disimpan");
//        try {
//            distributorRepository.save(distributor);
//        } catch (Exception e) {
//            map.put("msg", "Data gagal disimpan");
//        }
//        return map;
//    }

}
