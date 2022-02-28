package com.evos.business;

import com.evos.model.dao.CategoriaDAO;
import com.evos.model.entity.Categoria;
import com.evos.model.vo.CategoriaVO;
import com.evos.model.vo.UsuarioVO;
import com.evos.util.Exception.EvosException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SessionBeanCategoria {

    private CategoriaDAO categoriaDAO;

    public void cadastrarCategoria(CategoriaVO categoria, UsuarioVO userLogado) throws EvosException {
        categoria.setLoginInc(userLogado.getNome());
        categoria.setDtaInc(Calendar.getInstance().toString());
        categoriaDAO.cadastrarCategoria(categoria);
    }

    public void alterarCategoria(CategoriaVO categoria, UsuarioVO userLogado) throws EvosException {
        categoria.setLoginAlt(userLogado.getNome());
        categoria.setDtaAlt(Calendar.getInstance().toString());
        categoriaDAO.alterarCategoria(categoria);
    }

    public void deletarCategoria(CategoriaVO categoria) throws EvosException {
        categoriaDAO.deletarCategoria(categoria.getId());
    }

    public List<CategoriaVO> recuperarTodasCategorias() throws EvosException {
        List<Categoria> categorias = categoriaDAO.recuperarCategorias();
        List<CategoriaVO> categoriasVO = new ArrayList<CategoriaVO>();

        if (categorias != null) {
            for (Categoria categoria : categorias) {
                categoriasVO.add(preencherVO(categoria));
            }
            return categoriasVO;
        }
        return null;
    }

    public CategoriaVO recuperarCategoriaPorId(long id) throws EvosException {
        Categoria categoria = categoriaDAO.recuperarCategoriaPorId(id);

        if (categoria != null) {
            return preencherVO(categoria);
        }
        return null;
    }

    public CategoriaVO preencherVO(Categoria categoria) {
        CategoriaVO categoriaVO = new CategoriaVO();
        categoriaVO.setId(categoria.getId());
        categoriaVO.setNome(categoria.getNome());
        categoriaVO.setAtivo(categoria.getAtivo().equals("S") ? true : false);
        categoriaVO.setDtaInc(categoria.getDtaInc());
        categoriaVO.setLoginInc(categoria.getLoginInc());
        categoriaVO.setDtaAlt(categoria.getDtaAlt());
        categoriaVO.setLoginAlt(categoria.getLoginAlt());
        return categoriaVO;
    }
}
