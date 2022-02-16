package com.evos.business;

import com.evos.model.dao.CargoDAO;
import com.evos.model.entity.Cargo;
import com.evos.model.entity.Usuario;
import com.evos.model.vo.CargoVO;
import com.evos.model.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SessionBeanCargo {

    private CargoDAO cargoDAO;

    public void cadastrarCargo(CargoVO cargo, UsuarioVO userLogado) {
        cargo.setLoginInc(userLogado.getNome());
        cargo.setDtaInc(Calendar.getInstance().toString());
        cargoDAO.cadastrarCargo(cargo);
    }

    public void alterarCargo(CargoVO cargo, UsuarioVO userLogado) {
        cargo.setLoginAlt(userLogado.getNome());
        cargo.setDtaAlt(Calendar.getInstance().toString());
        cargoDAO.alterarCargo(cargo);
    }

    public void deletarCargo(CargoVO cargo) {
        cargoDAO.deletarCargo(cargo.getId());
    }

    public void substituirCargoPorExistente(CargoVO cargo, CargoVO cargoExistente, int opcao, UsuarioVO userLogado) {
        // TODO: Alterar toda tabela que tiver o cargo antigo, excete relatórios
        cargoDAO.substituirCargoUsuario(cargo, cargoExistente, userLogado);

        // opcao: 1 Manter / 2 Desativar / 3 Excluir
        switch (opcao) {
            case 2:
                cargo.setAtivo(false);
                alterarCargo(cargo, userLogado);
                break;
            case 3:
                cargoDAO.deletarCargo(cargo.getId());
                break;
            default:
                break;
        }
    }

    public List<CargoVO> recuperarTodosCargo() {
        List<Cargo> cargos = cargoDAO.recuperarCargos();
        List<CargoVO> cargosVO = new ArrayList<CargoVO>();

        if (cargos != null) {
            for (Cargo cargo : cargos) {
                cargosVO.add(preencherVO(cargo));
            }
            return cargosVO;
        }
        return null;
    }

    public CargoVO recuperarCargoPorId(long id) {
        Cargo cargo = cargoDAO.recuperarCargoPorId(id);

        if (cargo != null) {
            return preencherVO(cargo);
        }
        return null;
    }

    public CargoVO preencherVO(Cargo cargo) {
        CargoVO cargoVO = new CargoVO();
        cargoVO.setId(cargo.getId());
        cargoVO.setNome(cargo.getNome());
        cargoVO.setAtivo(cargo.getAtivo().equals("S") ? true : false);
        cargoVO.setDtaInc(cargo.getDtaInc());
        cargoVO.setLoginInc(cargo.getLoginInc());
        cargoVO.setDtaAlt(cargo.getLoginAlt());
        cargoVO.setLoginAlt(cargo.getLoginAlt());
        return cargoVO;
    }
}
