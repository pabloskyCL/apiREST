package com.apiRest.pabloq.apiREST.Respositories;

import com.apiRest.pabloq.apiREST.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository  extends JpaRepository<Product, Long>{

}
