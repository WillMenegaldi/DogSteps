package br.com.dogsteps.interfaces;

public interface IEstatistica<T, E> {
    public E getPasseiosEstatistica();
    public T getTotalCadastroDogWalker();
    public T getMediaPetsPorTutor();
    public T getMediaIdadePasseadores();
    public E getMediaHorarioPasseio();
}
