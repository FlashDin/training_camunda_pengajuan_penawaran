package co.id.javan.pengajuanproduk.controllers;

import co.id.javan.pengajuanproduk.pojo.Produk;
import co.id.javan.pengajuanproduk.repositories.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    @PostMapping(path = "/db")
//    public Map<String, Object> save(@RequestBody Produk produk) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("msg", "Data berhasil disimpan");
//        try {
//            produkRepository.save(produk);
//        } catch (Exception e) {
//            map.put("msg", "Data gagal disimpan");
//        }
//        return map;
//    }

}
