package com.evos.business;

import com.evos.model.entity.Produto;
import com.evos.model.vo.ProdutoVO;

public class SessionBeanProduto {

    public Produto recuperarProdutoPorId(long id) {
        String query = "SELECT * FROM PRODUTO WHERE id = ?";
        Produto produto = new Produto();

        try {

        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return produto;
    }

    public ProdutoVO preencherVO(Produto produto) {
        ProdutoVO produtoVO = new ProdutoVO();

        return produtoVO;
    }
}
