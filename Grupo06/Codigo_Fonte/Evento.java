package Codigo_Fonte;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Evento{
    private Data DataInicio,DataFim;
    private String local,titulo;
    private Usuario[] convidados = new Usuario[50]; //mudar pra arraylist na v3
    private int contadorConvidados;
    private boolean confirmado;

    //construtores
    
    public Evento(String titulo, String local, int diaInicio, int mesInicio, int anoInicio, int diaFim, int mesFim, int anoFim, int horaIncio, int minutoInicio, int horaFim, int minutoFim){

        this.titulo = titulo;
        this.local = local;

        DataInicio = new Data(diaInicio, mesInicio, anoInicio, horaIncio, minutoInicio);
        DataFim = new Data(diaFim, mesFim, anoFim, horaFim, minutoFim);

        //continuar na v3
        

    }

    /*public Evento(String titulo, String local, Data DataInicio, Data DataFim){

        this.titulo = titulo;
        this.local = local;
        /*
        if(validaDatas(DataInicio, DataFim)){
            this.DataInicio = DataInicio;
            this.DataFim = DataFim;
        }
        else throw new IllegalArgumentException("Datas de Inicio e Fim inválidas.");
        //this.confirmado = confirmado;
        /*
        this.contadorConvidados = contadorConvidados;
        for(int i=0;i<contadorConvidados;i++){
            this.convidados[i] = convidados[i];
        }
    }*/  

    //metodos
    /*public void verListaConvidados(){
        for(int i=0;i<contadorConvidados;i++){
            System.out.println("Convidado "+(i+1)+": "+convidados[i].getitulo());
        }
    }*/
    public void DuracaoEvento(){
        LocalDateTime inicio = LocalDateTime.of(DataInicio.getAno(), DataInicio.getMes(), DataInicio.getDia(), DataInicio.getHora(), DataInicio.getMinuto());
        LocalDateTime fim = LocalDateTime.of(DataFim.getAno(), DataFim.getMes(), DataFim.getDia(), DataFim.getHora(), DataFim.getMinuto());
        long diferencaEmDias = ChronoUnit.DAYS.between(inicio, fim);
        long diferencaEmHoras = ChronoUnit.HOURS.between(inicio, fim)%24;
        long diferencaEmMinutos = ChronoUnit.MINUTES.between(inicio, fim)%60;
        System.out.printf("O Evento tem duração de %d dia(s), %d hora(s), %d minuto(s)\n", diferencaEmDias, diferencaEmHoras, diferencaEmMinutos);
    }
    /*
    public void visualizarEvento(){
        System.out.println("titulo do Evento: "+titulo);
        System.out.println("Local: "+local);
        System.out.println("Data de Início: "+DataInicio.toString());
        System.out.println("Data de Fim: "+DataFim.toString());
        System.out.println("Confirmado: "+(confirmado ? "Sim" : "Não"));
        System.out.println("Número de Convidados: "+contadorConvidados);
    }
    */
    @Override
    public String toString() {
        String eventoTitulo = "titulo do Evento: "+ this.getTitulo();
        String eventoLocal = "Local: "+ this.getLocal();
        String dtInicio = "Data de Início: "+ DataInicio.toString();
        String dtFim = "Data de Fim: "+ DataFim.toString();
        String confirmado = "Confirmado: "+ (this.confirmado ? "Sim" : "Não");
        String numConvidados = "Número de Convidados: "+ String.valueOf(contadorConvidados);

        String eventoString = eventoTitulo + System.lineSeparator() + eventoLocal + System.lineSeparator() + dtInicio + System.lineSeparator() + dtFim + System.lineSeparator() + confirmado + System.lineSeparator() + numConvidados;

        return eventoString;
    }

    private boolean validaDatas(Data DataInicio, Data DataFim) {
        LocalDateTime inicio = LocalDateTime.of(DataInicio.getAno(), DataInicio.getMes(), DataInicio.getDia(), DataInicio.getHora(), DataInicio.getMinuto());
        LocalDateTime fim = LocalDateTime.of(DataFim.getAno(), DataFim.getMes(), DataFim.getDia(), DataFim.getHora(), DataFim.getMinuto());
        return inicio.isBefore(fim);
    }

    //getters e setters
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLocal(){
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }

    public String getDataInicio(){
        return DataInicio.toString();
    }
    public void setDataInicio(int dia, int mes, int ano) {
        DataInicio.setDia(dia);
        DataInicio.setMes(mes);
        DataInicio.setAno(ano);
    }


    public String getDataFim(){
        return DataFim.toString();
    }
    public void setDataFim(int dia, int mes, int ano) {
        DataFim.setDia(dia);
        DataFim.setMes(mes);
        DataFim.setAno(ano);
    }

    public Usuario[] getConvidados(){
        return convidados;
    }
    public void setConvidados(Usuario[] convidados) {
        this.convidados = convidados;
    }

    public int getContadorConvidados(){
        return contadorConvidados;
    }
    public void setContadorConvidados(int contadorConvidados) {
        this.contadorConvidados = contadorConvidados;
    }

    public boolean getConfirmado(){
        return confirmado;
    }
    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    //alteração de data (específicos)
    public void alteraDiaDataInicio(int dia){
        DataInicio.setDia(dia);
    }
    public void alteraMesDataInicio(int mes){
        DataInicio.setMes(mes);
    }
    public void alteraAnoDataInicio(int ano){
        DataInicio.setAno(ano);
    }

    public void alteraDiaDataFim(int dia){
        DataFim.setDia(dia);
    }
    public void alteraMesDataFim(int mes){
        DataFim.setDia(mes);
    }
    public void alteraAnoDataFim(int ano){
        DataFim.setDia(ano);
    }

    //alteração de hora
    public void alteraHorarioInicio(int valor, int aux) {
        if (aux == 0) {
            DataInicio.setHora(valor);
        } else if (aux == 1) {
            DataInicio.setMinuto(valor);
        } else {
            throw new IllegalArgumentException("Valor de 'aux' inválido.");
        }
    }
    
    public void alteraHorarioFim(int valor, int aux) {
        if (aux == 0) {
            DataFim.setHora(valor);
        } else if (aux == 1) {
            DataFim.setMinuto(valor);
        } else {
            throw new IllegalArgumentException("Valor de 'aux' inválido.");
        }
    }
    
}