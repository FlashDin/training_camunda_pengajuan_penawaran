package co.id.javan.pengajuanproduk.controllers;

import co.id.javan.pengajuanproduk.pojo.Produk;
import co.id.javan.pengajuanproduk.repositories.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task/produk")
public class ProdukController {

    @Autowired
    private ProdukRepository produkRepository;
    @GetMapping(path = "/db/all")
    public List<Produk> findAll() {
        return produkRepository.findAll();
    }

    @GetMapping(path = "/db/{id}")
    public Produk findById(@PathVariable long id) {
        return produkRepository.findById(id).get();
    }

    @PostMapping(path = "/db")
    public Produk save(@RequestBody Produk distributor) {
        return produkRepository.save(distributor);
    }

}
