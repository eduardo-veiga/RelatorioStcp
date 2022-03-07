package com.example.relatoriostcp.activity.model;

public class Atividade {

    private String _id;
    private String _01_data;
    private String _02_semana;
    private String _03_horainicioCadastro;
    private String _04_horafimCadastro;
    private String _05_responsavel;
    private String _06_talhao;
    private String _07_atividade;
    private String _08_subatividade;
    private String _09_producao;
    private String _10_unidade;
    private String _11_numcolaboradores;
    private String _12_horainiprod;
    private String _13_horafimprod;
    private String _14_observacao;
    private String _15_deslocini;
    private String _16_deslocfim;
    private String _17_almocoini;
    private String _18_almocofim;


    public Atividade() {
    }


    public Atividade(String _id, String _01_data, String _02_semana, String _05_responsavel,
                     String _06_talhao, String _07_atividade, String _08_subatividade,
                     String _10_unidade, String _09_producao, String _11_numcolaboradores,
                     String _03_horainicioCadastro, String _04_horafimCadastro, String _12_horainiprod, String _13_horafimprod,
                     String _14_observacao, String _15_deslocini, String _16_deslocfim, String _17_almocoini, String _18_almocofim) {
            this._id = _id;
        this._01_data = _01_data;
        this._02_semana = _02_semana;
        this._05_responsavel = _05_responsavel;
        this._06_talhao = _06_talhao;
        this._07_atividade = _07_atividade;
        this._08_subatividade = _08_subatividade;
        this._10_unidade = _10_unidade;
        this._09_producao = _09_producao;
        this._11_numcolaboradores = _11_numcolaboradores;
        this._14_observacao = _14_observacao;
        this._03_horainicioCadastro = _03_horainicioCadastro;
        this._04_horafimCadastro = _04_horafimCadastro;
        this._12_horainiprod = _12_horainiprod;
        this._13_horafimprod = _13_horafimprod;
        this._15_deslocini = _15_deslocini;
        this._16_deslocfim = _16_deslocfim;
        this._17_almocoini = _17_almocoini;
        this._18_almocofim = _18_almocofim;
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_05_responsavel() {return _05_responsavel;}

    public void set_05_responsavel(String _05_responsavel) {this._05_responsavel = _05_responsavel;}

    public String get_06_talhao() {return _06_talhao;}

    public void set_06_talhao(String _06_talhao) {this._06_talhao = _06_talhao;}

    public String get_08_subatividade() {return _08_subatividade;}

    public void set_08_subatividade(String _08_subatividade) {this._08_subatividade = _08_subatividade;}

    public String get_10_unidade() {return _10_unidade;}

    public void set_10_unidade(String _10_unidade) {this._10_unidade = _10_unidade;}

    public String get_11_numcolaboradores() {return _11_numcolaboradores;}

    public void set_11_numcolaboradores(String _11_numcolaboradores) {this._11_numcolaboradores = _11_numcolaboradores;}

    public String get_14_observacao() {return _14_observacao;}

    public void set_14_observacao(String _14_observacao) {this._14_observacao = _14_observacao;}

    public String get_07_atividade() {        return _07_atividade;    }

    public void set_07_atividade(String _07_atividade) {        this._07_atividade = _07_atividade;    }

    public String get_01_data() {        return _01_data;    }

    public void set_01_data(String _01_data) {        this._01_data = _01_data;    }

    public String get_09_producao() {        return _09_producao;    }

    public void set_09_producao(String _09_producao) {this._09_producao = _09_producao;    }

    public String get_02_semana() {return _02_semana;}

    public void set_02_semana(String semana) {this._02_semana = _02_semana;}

    public String get_03_horainicioCadastro() {return _03_horainicioCadastro; }

    public void set_03_horainicioCadastro(String _03_horainicioCadastro) { this._03_horainicioCadastro = _03_horainicioCadastro; }

    public String get_04_horafimCadastro() { return _04_horafimCadastro;}

    public void set_04_horafimCadastro(String _04_horafimCadastro) { this._04_horafimCadastro = _04_horafimCadastro; }

    public String get_12_horainiprod() {return _12_horainiprod;}

    public void set_12_horainiprod(String _12_horainiprod) {this._12_horainiprod = _12_horainiprod;}

    public String get_13_horafimprod() {return _13_horafimprod;}

    public void set_13_horafimprod(String _13_horafimprod) {this._13_horafimprod = _13_horafimprod;}

    public String get_15_deslocini() {return _15_deslocini; }

    public void set_15_deslocini(String _15_deslocini) { this._15_deslocini = _15_deslocini; }

    public String get_16_deslocfim() { return _16_deslocfim; }

    public void set_16_deslocfim(String _16_deslocfim) {this._16_deslocfim = _16_deslocfim; }

    public String get_17_almocoini() { return _17_almocoini;}

    public void set_17_almocoini(String _17_almocoini) {this._17_almocoini = _17_almocoini;}

    public String get_18_almocofim() {return _18_almocofim;}

    public void set_18_almocofim(String _18_almocofim) {this._18_almocofim = _18_almocofim;}
}
    

