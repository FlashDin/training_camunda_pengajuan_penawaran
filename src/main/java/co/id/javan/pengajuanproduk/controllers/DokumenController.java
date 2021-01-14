package co.id.javan.pengajuanproduk.controllers;

import co.id.javan.pengajuanproduk.pojo.Dokumen;
import co.id.javan.pengajuanproduk.repositories.DokumenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/task/dokumen")
public class DokumenController {

    @Autowired
    private DokumenRepository dokumenRepository;

    @GetMapping(path = "/db/all")
    public List<Dokumen> findAll() {
        return dokumenRepository.findAll();
    }

    @GetMapping(path = "/db/{id}")
    public Dokumen findById(@PathVariable long id) {
        return dokumenRepository.findById(id).get();
    }

    @PostMapping(path = "/db")
    public Map<String, Object> save(@RequestBody Dokumen distributor) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "Data berhasil disimpan");
        try {
            dokumenRepository.save(distributor);
        } catch (Exception e) {
            map.put("msg", "Data gagal disimpan");
        }
        return map;
    }

}
