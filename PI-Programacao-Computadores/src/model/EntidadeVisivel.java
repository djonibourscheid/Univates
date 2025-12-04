package model;


public abstract class EntidadeVisivel {
    private boolean visivel = true;

    public boolean isVisivel() {
        return visivel;
    }

    public void excluir() {
        this.visivel = false;
    }

    public boolean validarVisibilidade() {
        if (visivel) return true;

        System.out.println("=> O código informado não consta nos registros. Tente novamente. <=\n");
        return false;
    }
}