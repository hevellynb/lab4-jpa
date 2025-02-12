package org.example.servico;

import org.example.modelo.*;
import org.example.repositorios.ImovelRepository;
import org.example.repositorios.LocacaoRepository;

public class LocacaoService {
    private LocacaoRepository locacaoRepository;
    private ImovelRepository imovelRepository;

    public LocacaoService(LocacaoRepository locacaoRepository, ImovelRepository imovelRepository) {
        this.locacaoRepository = locacaoRepository;
        this.imovelRepository = imovelRepository;
    }

    public void registrarLocacao(Locacao locacao) {
        if (!locacao.getImovel().getDisponivel()) {
            throw new IllegalStateException("O imóvel já está alugado");
        }
        locacao.getImovel().setDisponivel(false);
        imovelRepository.atualizar(locacao.getImovel());
        locacaoRepository.salvar(locacao);
    }
}
