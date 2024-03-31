package Codigo_Fonte;

    public class Usuario {
        
        private String nome;
        private String email;
        private String senha;
        private Agenda agenda;


        //construtores 
        public Usuario(String nome, String email, String senha) {
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.agenda = new Agenda(this);
        }


        //metodos

        //criação e cancelamento de eventos

/*
        public void criarEvento(Evento evento) {
            this.agenda.adicionarEvento(evento);
        }
 */
        public void criarEvento(String titulo, String local, int diaInicio, int mesInicio, int anoInicio, int diaFim, int mesFim, int anoFim, int horaIncio, int minutoInicio, int horaFim, int minutoFim){
            Evento evento = new Evento(titulo, local, diaInicio, mesInicio, anoInicio, diaFim, mesFim, anoFim, horaIncio, minutoInicio, horaFim, minutoFim);

            agenda.adicionarEvento(evento);
        }

        public void cancelarEvento(String titulo) {
            agenda.removerEvento(titulo);
        }
/*
        public void editarEvento(Evento evento, String novoNome, LocalDateTime novaData) {
            evento.setNome(novoNome);
            evento.setData(novaData);
        } 
/*
        public void visualizarEvento(Evento evento) {
            System.out.println(evento);
        }
*/
        public void confirmaEvento(Evento evento){
            evento.setConfirmado(true);
        }

        public void recusaEvento(Evento evento){
            evento.setConfirmado(false);
        }

        //getters e setters
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }
}

