package src.br.com.dio.model;


public class Space {
    // o que o usuário vai inserir
    private Integer actual; 
    // o valor esperado
    private final int expected;
    // se pode ser alterado
    private final boolean fixed;

    // criando um construtor
    public Space(final int expected, final boolean fixed) {
        this.expected = expected;
        this.fixed = fixed;
        if (fixed) {
            actual = expected;
        }
    }

    // get e setter 
    public Integer getActual() {
        return actual;
    }

    public void setActual(Integer actual) {
     if (fixed) return;  
    this.actual = actual;
    }
    
    public void clearSpace(){
        setActual(null);
    }

    public int getExpected() {
        return expected;
    }

    public boolean isFixed() {
        return fixed;
    }
    
}
