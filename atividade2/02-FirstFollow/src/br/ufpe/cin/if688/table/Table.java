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
            //caso tenha epsilon no first do nao terminal da producao
            if(first.get(element.getNonterminal()).contains(SpecialSymbol.EPSILON)) {
                //varrendo o conjunto first do nao terminal
                for(GeneralSymbol generalSymbol : first.get(element.getNonterminal())) {
                    //caso generalSymbol não seja epsilon e nao haja epsilon na producao de element
                    if(!generalSymbol.equals(SpecialSymbol.EPSILON) && !element.getProduction().contains(SpecialSymbol.EPSILON)) {
                        LL1Key key = new LL1Key(element.getNonterminal(), generalSymbol);
                        parsingTable.put(key, element.getProduction());
                    }

                    //caso generalSymbol seja epsilon e haja epsilon na producao de element
                    else if(generalSymbol.equals(SpecialSymbol.EPSILON) && element.getProduction().contains(SpecialSymbol.EPSILON)) {
                        //varrendo o conjunto follow do nao terminal
                        for(GeneralSymbol sbl : follow.get(element.getNonterminal())) {
                            LL1Key key = new LL1Key(element.getNonterminal(), sbl);
                            parsingTable.put(key, element.getProduction());
                        }
                    }
                }
            }

            //caso nao tenha epsilon no first do nao terminal da producao
            if(!first.get(element.getNonterminal()).contains(SpecialSymbol.EPSILON)) {
                //varrendo o conjunto first do nao terminal
                for(GeneralSymbol generalSymbol : first.get(element.getNonterminal())) {
                    //caso seja um nao terminal
                    if(!((Symbol)(element.getProduction().get(0))).isTerminal()) {
                        LL1Key key = new LL1Key(element.getNonterminal(), generalSymbol);
                        parsingTable.put(key, element.getProduction());
                    }
                    else {
                        //sendo um terminal, verifica se ele esta na producao de element
                        if(element.getProduction().contains(generalSymbol)) {
                            LL1Key key = new LL1Key(element.getNonterminal(), generalSymbol);
                            parsingTable.put(key, element.getProduction());
                        }
                    }
                }
            }
        }

        System.out.print(g);
        System.out.println(first);
        System.out.println(follow);
        System.out.println(sortTable(parsingTable));

        return sortTable(parsingTable);
    }

    static private Map<LL1Key, List<GeneralSymbol>> sortTable( Map<LL1Key, List<GeneralSymbol>> parsingTable) {
        // This sorts only the key, as the values in the set must be in the order of the rule
        Map<LL1Key, List<GeneralSymbol>> sortedMap = new TreeMap<LL1Key, List<GeneralSymbol>>(new Comparator<LL1Key>() {
            @Override
            public int compare(LL1Key t1, LL1Key t2) {
                return t1.toString().compareTo(t2.toString());
            }
        });

        parsingTable.forEach((k,v)->{
            sortedMap.put(k, v);
        });

        return sortedMap;
    }
}
