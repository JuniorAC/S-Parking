package control;


import entity.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class Funcionarios {
        private List<Funcionario> listFuncionarios = new ArrayList<>();

        public void cadastrar (Funcionario f){
                listFuncionarios.add(f);
        }

        public Funcionario loginFuncionario(String usuario, String senha){
            for (Funcionario f : listFuncionarios){
                if (f.getUsuario().equals(usuario) && f.getSenha().equals(senha)){
                    System.out.println("ok login realizado com sucesso");
                    return f;
                }else {
                System.out.println("senha errada");
                }

            }
            return null;
        }
}
