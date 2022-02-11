package com.evos.business;

import com.evos.model.entity.Categoria;
import com.evos.model.vo.CategoriaVO;

public class SessionBeanCategoria {

    public Categoria recuperarCategoriaPorId(long id) {
        String query = "SELECT * FROM CATEGORIA WHERE id = ?";
        Categoria categoria = new Categoria();

        return categoria;
    }

    public CategoriaVO preencherVO(Categoria categoria) {
        CategoriaVO categoriaVO = new CategoriaVO();

        return categoriaVO;
    }
}
