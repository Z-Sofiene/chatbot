package tn.i_sante.bpo.chatbot.service;

import tn.i_sante.bpo.chatbot.entity.TiersPayant;

import java.util.List;

public interface TiersPayantService {
    TiersPayant getTiersPayantById(String num_transaction);
    List<TiersPayant> getAllTiersPayants();
    TiersPayant addTiersPayant(TiersPayant tiersPayant);
    TiersPayant updateTiersPayant(TiersPayant tiersPayant);
    void deleteTiersPayant(String num_transaction);
    //List
}
