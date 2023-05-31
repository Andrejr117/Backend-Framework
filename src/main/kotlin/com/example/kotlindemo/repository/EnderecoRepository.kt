package com.example.kotlindemo.repository


import com.example.kotlindemo.model.Endereco
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by rajeevkumarsingh on 04/10/17.
 */
@Repository
interface EnderecoRepository : JpaRepository<Endereco, Long>{


}