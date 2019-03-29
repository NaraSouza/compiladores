package br.ufpe.cin.if688.table;


import br.ufpe.cin.if688.parsing.analysis.*;
import br.ufpe.cin.if688.parsing.grammar.*;
import java.util.*;


public final class Table {
    private Table() {    }

    public static Map<LL1Key, List<GeneralSymbol>> createTable(Grammar g) throws NotLL1Exception {
        if (g == null) throw new NullPointerException();

        Map<Nonterminal, Set<GeneralSymbol>> first =
                SetGenerator.getFirst(g);
        Map<Nonterminal, Set<GeneralSymbol>> follow =
                SetGenerator.getFollow(g, first);

        Map<LL1Key, List<GeneralSymbol>> parsingTable =
                new HashMap<LL1Key, List<GeneralSymbol>>();

        /*
         * Implemente aqui o método para retornar a parsing table
         */

        for(Production element : g.getProductions()) {
            //caso tenha epsilon no first
            if(first.get(element.getNonterminal()).contains(SpecialSymbol.EPSILON)) {
                for(GeneralSymbol x : first.get(element.getNonterminal())) {
                    //se x não for o epsilon
                    if(!x.equals(SpecialSymbol.EPSILON) && !element.getProduction().contains(SpecialSymbol.EPSILON)) {
                        LL1Key Xx = new LL1Key(element.getNonterminal(), x);
                        parsingTable.put(Xx, element.getProduction());
                    }

                    //se x for o epsilon
                    else if(x.equals(SpecialSymbol.EPSILON) && element.getProduction().contains(SpecialSymbol.EPSILON)) {
                        for(GeneralSymbol sbl : follow.get(element.getNonterminal())) {
                            LL1Key Xx = new LL1Key(element.getNonterminal(), sbl);
                            parsingTable.put(Xx, element.getProduction());
                        }
                    }
                }
            }

            //caso nao tenha epsilon no first
            if(!first.get(element.getNonterminal()).contains(SpecialSymbol.EPSILON)) {
                for(GeneralSymbol x : first.get(element.getNonterminal())) {
                    if(!((Symbol)(element.getProduction().get(0))).isTerminal()) {
                        LL1Key Xx = new LL1Key(element.getNonterminal(), x);
                        parsingTable.put(Xx, element.getProduction());
                    }
                    else {
                        if(element.getProduction().contains(x)) {
                            LL1Key Xx = new LL1Key(element.getNonterminal(), x);
                            parsingTable.put(Xx, element.getProduction());
                        }
                    }
                }
            }
        }

        return parsingTable;
    }
}
