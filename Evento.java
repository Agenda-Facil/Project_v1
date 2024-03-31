package Codigo_Fonte;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Evento{
    private Data DataInicio,DataFim;
    private String local,titulo;
    private List<Usuario> convidados = new ArrayList<Usuario>();
    private boolean confirmado;

    // Construtor da Classe Evento
    public Evento(String titulo, String local, int diaInicio, int mesInicio, int anoInicio, int diaFim, int mesFim, int anoFim, int horaInicio, int minutoInicio, int horaFim, int minutoFim){

        this.titulo = titulo;
        this.local = local;

        DataInicio = new Data(diaInicio, mesInicio, anoInicio, horaInicio, minutoInicio);
        DataFim = new Data(diaFim, mesFim, anoFim, horaFim, minutoFim);
        //caso a dataFim esteja vindo antes da dataInicio, criamos uma exceção
        if(!validaDatas(DataInicio, DataFim)) throw new IllegalArgumentException("Datas de Inicio e Fim inválidas.");
    }

    // Método que apresenta a duração do Evento
    public void DuracaoEvento(){
        LocalDateTime inicio = LocalDateTime.of(DataInicio.getAno(), DataInicio.getMes(), DataInicio.getDia(), DataInicio.getHora(), DataInicio.getMinuto());
        LocalDateTime fim = LocalDateTime.of(DataFim.getAno(), DataFim.getMes(), DataFim.getDia(), DataFim.getHora(), DataFim.getMinuto());
        long diferencaEmDias = ChronoUnit.DAYS.between(inicio, fim);
        long diferencaEmHoras = ChronoUnit.HOURS.between(inicio, fim)%24;
        long diferencaEmMinutos = ChronoUnit.MINUTES.between(inicio, fim)%60;
        System.out.printf("O Evento tem duração de %d dia(s), %d hora(s), %d minuto(s)\n", diferencaEmDias, diferencaEmHoras, diferencaEmMinutos);
    }
    
    @Override
    // Método toString para representar o Evento como String
    public String toString() {
        String eventoTitulo = "titulo do Evento: "+ this.getTitulo();
        String eventoLocal = "Local: "+ this.getLocal();
        String dtInicio = "Data de Início: "+ DataInicio.toString();
        String dtFim = "Data de Fim: "+ DataFim.toString();
        String confirmado = "Confirmado: "+ (this.confirmado ? "Sim" : "Não");
        String numConvidados = "Número de Convidados: "+ String.valueOf(convidados.size());
        String convidados_string = "Os convidados são: [";
        for(Usuario c:convidados){
            convidados_string += c.getNome() + ", ";
        }
        //para remover o ", " do último nome, para não ficar, por exemplo: [Andressa, ]. obs: remove o ", " apenas se existir alguem
        if(convidados.size()>0) convidados_string = convidados_string.substring(0,convidados_string.length()-2);
        convidados_string += "]";
        String eventoString = eventoTitulo + System.lineSeparator() + eventoLocal + System.lineSeparator() + dtInicio + System.lineSeparator() + dtFim + System.lineSeparator() + confirmado + System.lineSeparator() + numConvidados + System.lineSeparator() + convidados_string + System.lineSeparator();
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

    public boolean getConfirmado(){
        return confirmado;
    }
    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public List<Usuario> getConvidados(){
        return convidados;
    }
    public void setConvidados(List<Usuario> convidados) {
        this.convidados = convidados;
    }

    // Métodos que alteram especificamente a hora/minuto da DataInicio ou dataFim
    public void alteraHorarioInicio(int valor, int aux) {
        if (aux == 0) DataInicio.setHora(valor);
        else DataInicio.setMinuto(valor);
        if(!validaDatas(DataInicio, DataFim)) throw new IllegalArgumentException("Datas de Inicio e Fim inválidas.");
    }
    
    public void alteraHorarioFim(int valor, int aux) {
        if (aux == 0) DataFim.setHora(valor);
        else DataFim.setMinuto(valor);
        if(!validaDatas(DataInicio, DataFim)) throw new IllegalArgumentException("Datas de Inicio e Fim inválidas.");
    }
    
    // Métodos que alteram a DataInicio
    public void alteraDiaDataInicio(int dia){
        DataInicio.setDia(dia);
        if(!validaDatas(DataInicio, DataFim)) throw new IllegalArgumentException("Datas de Inicio e Fim inválidas.");
    }
    public void alteraMesDataInicio(int mes){
        DataInicio.setMes(mes);
        if(!validaDatas(DataInicio, DataFim)) throw new IllegalArgumentException("Datas de Inicio e Fim inválidas.");
    }
    public void alteraAnoDataInicio(int ano){
        DataInicio.setAno(ano);
        if(!validaDatas(DataInicio, DataFim)) throw new IllegalArgumentException("Datas de Inicio e Fim inválidas.");
    }
    
    // Métodos que alteram a DataFim
    public void alteraDiaDataFim(int dia){
        DataFim.setDia(dia);
        if(!validaDatas(DataInicio, DataFim)) throw new IllegalArgumentException("Datas de Inicio e Fim inválidas.");
    }
    public void alteraMesDataFim(int mes){
        DataFim.setMes(mes);
        if(!validaDatas(DataInicio, DataFim)) throw new IllegalArgumentException("Datas de Inicio e Fim inválidas.");
    }
    public void alteraAnoDataFim(int ano){
        DataFim.setAno(ano);
        if(!validaDatas(DataInicio, DataFim)) throw new IllegalArgumentException("Datas de Inicio e Fim inválidas.");
    }
}
