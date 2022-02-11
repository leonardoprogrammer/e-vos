package com.evos.model.dao;

import com.evos.ConnectionFactory;
import com.evos.model.entity.DescontoCompra;
import com.evos.model.entity.DescontoProduto;
import com.evos.model.vo.DescontoCompraVO;
import com.evos.model.vo.DescontoProdutoVO;
import com.evos.model.vo.ProdutoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DescontoDAO {

    public void cadastrarDescontoProduto(DescontoProdutoVO desconto) {
        StringBuilder query = new StringBuilder("INSERT INTO DESCONTOPRODUTO");
        query.append("(id_produto, qtd_minima, tipo_desconto, porcentagem, valor, apenas_um,");
        query.append(" ativo, dta_inc, login_inc, dta_alt, login_alt)");
        query.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        Connection conn = null;
        PreparedStatement pstm = null;

         try {
             // Cria conexão com o banco
             conn = ConnectionFactory.createConnectionToMySql();

             // Cria um PreparedStatement, classe usada para executar a query
             pstm = conn.prepareStatement(query.toString());

             // Adciona os valores como parâmetros
             pstm.setLong(1, desconto.getProduto().getId());
             pstm.setInt(2, desconto.getQtdMinima());
             pstm.setInt(3, desconto.getTipoDesconto().getId());
             pstm.setDouble(4, desconto.getPorcentagem());
             pstm.setDouble(5, desconto.getValor());
             pstm.setString(6, desconto.isApenasUmDesconto() ? "S" : "N");
             pstm.setString(7, desconto.isAtivo() ? "S" : "N");
             pstm.setString(8, desconto.getDtaInc());
             pstm.setString(9, desconto.getLoginInc());
             pstm.setString(10, desconto.getDtaAlt());
             pstm.setString(11, desconto.getLoginAlt());

             // Executa a query para inserção dos dados
             pstm.execute();
         } catch (Exception e) {
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
    }

    public void cadastrarDescontoCompra(DescontoCompraVO desconto) {
        StringBuilder query = new StringBuilder("INSERT INTO DESCONTOCOMPRA");
        query.append("(qtd_minima, tipo_desconto, porcentagem, valor, ativo,");
        query.append(" dta_inc, login_inc, dta_alt, login_alt)");
        query.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setInt(1, desconto.getQtdMininaProdutos());
            pstm.setInt(2, desconto.getTipoDesconto().getId());
            pstm.setDouble(3, desconto.getPorcentagem());
            pstm.setDouble(4, desconto.getValor());
            pstm.setString(5, desconto.isAtivo() ? "S" : "N");
            pstm.setString(6, desconto.getDtaInc());
            pstm.setString(7, desconto.getLoginInc());
            pstm.setString(8, desconto.getDtaAlt());
            pstm.setString(9, desconto.getLoginAlt());

            pstm.execute();
        } catch (Exception e) {
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
    }

    public void alterarDescontoProduto(DescontoProdutoVO desconto) {
        StringBuilder query = new StringBuilder("UPDATE DESCONTOPRODUTO SET");
        query.append(" id_produto = ?, qtd_minima = ?, tipo_desconto = ?, porcentagem = ?,");
        query.append(" valor = ?, apenas_um = ?, ativo = ?, dta_inc = ?, login_inc = ?, dta_alt = ?, login_alt = ?");
        query.append(" WHERE id = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setLong(1, desconto.getProduto().getId());
            pstm.setInt(2, desconto.getQtdMinima());
            pstm.setInt(3, desconto.getTipoDesconto().getId());
            pstm.setDouble(4, desconto.getPorcentagem());
            pstm.setDouble(5, desconto.getValor());
            pstm.setString(6, desconto.isApenasUmDesconto() ? "S" : "N");
            pstm.setString(7, desconto.isAtivo() ? "S" : "N");
            pstm.setString(8, desconto.getDtaInc());
            pstm.setString(9, desconto.getLoginInc());
            pstm.setString(10, desconto.getDtaAlt());
            pstm.setString(11, desconto.getLoginAlt());
            pstm.setLong(12, desconto.getId());

            pstm.execute();
        } catch (Exception e) {
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
    }

    public void alterarDescontoCompra(DescontoCompraVO desconto) {
        StringBuilder query = new StringBuilder("UPDATE DESCONTOCOMPRA SET");
        query.append(" qtd_minima = ?, tipo_desconto = ?, porcentagem = ?, valor = ?,");
        query.append(" ativo = ?, dta_inc = ?, login_inc = ?, dta_alt = ?, login_alt = ?");
        query.append(" WHERE id = ?");

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query.toString());

            pstm.setInt(1, desconto.getQtdMininaProdutos());
            pstm.setInt(2, desconto.getTipoDesconto().getId());
            pstm.setDouble(3, desconto.getPorcentagem());
            pstm.setDouble(4, desconto.getValor());
            pstm.setString(5, desconto.isAtivo() ? "S" : "N");
            pstm.setString(6, desconto.getDtaInc());
            pstm.setString(7, desconto.getLoginInc());
            pstm.setString(8, desconto.getDtaAlt());
            pstm.setString(9, desconto.getLoginAlt());
            pstm.setLong(10, desconto.getId());

            pstm.execute();
        } catch (Exception e) {
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
    }

    public void ativarDesativarDescontoProduto(DescontoProdutoVO desconto, int opcao) {
        String query = "UPDATE DESCONTOPRODUTO SET ativo = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            // opcao: 1 Ativar / 2 Desativar
            if (opcao == 1) {
                pstm.setString(1, "S");
            } else if (opcao == 2) {
                pstm.setString(1, "N");
            }
            pstm.setLong(2, desconto.getId());

            pstm.execute();
        } catch (Exception e) {
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
    }

    public void ativarDesativarDescontoCompra(DescontoCompraVO desconto, int opcao) {
        String query = "UPDATE DESCONTOCOMPRA SET ativo = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            // opcao: 1 Ativar / 2 Desativar
            if (opcao == 1) {
                pstm.setString(1, "S");
            } else if (opcao == 2) {
                pstm.setString(1, "N");
            }
            pstm.setLong(2, desconto.getId());

            pstm.execute();
        } catch (Exception e) {
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
    }

    public void deletarDescontoProduto(DescontoProdutoVO desconto) {
        String query = "DELETE FROM DESCONTOPRODUTO WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, desconto.getId());

            pstm.execute();
        } catch (Exception e) {
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
    }

    public void deletarDescontoCompra(DescontoCompraVO desconto) {
        String query = "DELETE FROM DESCONTOCOMPRA WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, desconto.getId());

            pstm.execute();
        } catch (Exception e) {
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
    }

    public List<DescontoProduto> recuperarDescontosProduto() {
        String query = "SELECT * FROM DESCONTOPRODUTO";
        List<DescontoProduto> descontos = new ArrayList<DescontoProduto>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                DescontoProduto desconto = new DescontoProduto();

                desconto.setId(rs.getLong("id"));
                desconto.setIdProduto(rs.getLong("id_produto"));
                desconto.setQtdMinima(rs.getInt("qtd_minima"));
                desconto.setTipoDesconto(rs.getInt("tipo_desconto"));
                desconto.setPorcentagem(rs.getDouble("porcentagem"));
                desconto.setValor(rs.getDouble("valor"));
                desconto.setApenasUmDesconto(rs.getString("apenas_um"));
                desconto.setAtivo(rs.getString("ativo"));
                desconto.setDtaInc(rs.getString("dta_inc"));
                desconto.setLoginInc(rs.getString("login_inc"));
                desconto.setDtaAlt(rs.getString("dta_alt"));
                desconto.setLoginAlt(rs.getString("login_alt"));

                descontos.add(desconto);
            }
        } catch (Exception e) {
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
        return descontos;
    }

    public List<DescontoCompra> recuperarDescontosCompra() {
        String query = "SELECT * FROM DESCONTOCOMPRA";
        List<DescontoCompra> descontos = new ArrayList<DescontoCompra>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                DescontoCompra desconto = new DescontoCompra();

                desconto.setId(rs.getLong("id"));
                desconto.setQtdMininaProduto(rs.getInt("qtd_minima"));
                desconto.setTipoDesconto(rs.getInt("tipo_desconto"));
                desconto.setPorcentagem(rs.getDouble("porcentagem"));
                desconto.setValor(rs.getDouble("valor"));
                desconto.setAtivo(rs.getString("ativo"));
                desconto.setDtaInc(rs.getString("dta_inc"));
                desconto.setLoginInc(rs.getString("login_inc"));
                desconto.setDtaAlt(rs.getString("dta_alt"));
                desconto.setLoginAlt(rs.getString("login_alt"));

                descontos.add(desconto);
            }
        } catch (Exception e) {
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
        return descontos;
    }

    public DescontoProduto recuperarDescontoProdutoPorId(long id) {
        String query = "SELECT * FROM DESCONTOPRODUTO WHERE id = ?";
        DescontoProduto desconto = new DescontoProduto();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, id);

            rs = pstm.executeQuery();

            while (rs.next()) {
                desconto = new DescontoProduto();
                desconto.setId(rs.getLong("id"));
                desconto.setIdProduto(rs.getLong("id_produto"));
                desconto.setQtdMinima(rs.getInt("qtd_minima"));
                desconto.setTipoDesconto(rs.getInt("tipo_desconto"));
                desconto.setPorcentagem(rs.getDouble("porcentagem"));
                desconto.setValor(rs.getDouble("valor"));
                desconto.setApenasUmDesconto(rs.getString("apenas_um"));
                desconto.setAtivo(rs.getString("ativo"));
                desconto.setDtaInc(rs.getString("dta_inc"));
                desconto.setLoginInc(rs.getString("login_inc"));
                desconto.setDtaAlt(rs.getString("dta_alt"));
                desconto.setLoginAlt(rs.getString("login_alt"));
            }
        } catch (Exception e) {
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
        return desconto;
    }

    public DescontoCompra recuperarDescontoCompraPorId(long id) {
        String query = "SELECT * FROM DESCONTOCOMPRA WHERE id = ?";
        DescontoCompra desconto = new DescontoCompra();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, id);

            rs = pstm.executeQuery();

            while (rs.next()) {
                desconto = new DescontoCompra();

                desconto.setId(rs.getLong("id"));
                desconto.setQtdMininaProduto(rs.getInt("qtd_minima"));
                desconto.setTipoDesconto(rs.getInt("tipo_desconto"));
                desconto.setPorcentagem(rs.getDouble("porcentagem"));
                desconto.setValor(rs.getDouble("valor"));
                desconto.setAtivo(rs.getString("ativo"));
                desconto.setDtaInc(rs.getString("dta_inc"));
                desconto.setLoginInc(rs.getString("login_inc"));
                desconto.setDtaAlt(rs.getString("dta_alt"));
                desconto.setLoginAlt(rs.getString("login_alt"));
            }
        } catch (Exception e) {
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
        return desconto;
    }

    public DescontoProduto recuperarDescontoPorProduto(ProdutoVO produto) {
        String query = "SELECT * FROM DESCONTOPRODUTO WHERE id_produto = ?";
        DescontoProduto desconto = new DescontoProduto();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = conn.prepareStatement(query);

            pstm.setLong(1, produto.getId());

            rs = pstm.executeQuery();

            while (rs.next()) {
                desconto = new DescontoProduto();
                desconto.setId(rs.getLong("id"));
                desconto.setIdProduto(rs.getLong("id_produto"));
                desconto.setQtdMinima(rs.getInt("qtd_minima"));
                desconto.setTipoDesconto(rs.getInt("tipo_desconto"));
                desconto.setPorcentagem(rs.getDouble("porcentagem"));
                desconto.setValor(rs.getDouble("valor"));
                desconto.setApenasUmDesconto(rs.getString("apenas_um"));
                desconto.setAtivo(rs.getString("ativo"));
                desconto.setDtaInc(rs.getString("dta_inc"));
                desconto.setLoginInc(rs.getString("login_inc"));
                desconto.setDtaAlt(rs.getString("dta_alt"));
                desconto.setLoginAlt(rs.getString("login_alt"));
            }
        } catch (Exception e) {
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
        return desconto;
    }
}
