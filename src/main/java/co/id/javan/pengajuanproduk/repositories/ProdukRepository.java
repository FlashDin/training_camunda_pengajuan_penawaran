package co.id.javan.pengajuanproduk.repositories;

import co.id.javan.pengajuanproduk.pojo.Produk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdukRepository extends JpaRepository<Produk, Long> {
}
