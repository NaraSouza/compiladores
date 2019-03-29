package br.ufpe.cin.if688.parsing.analysis;

import java.util.*;

import br.ufpe.cin.if688.parsing.grammar.*;


public final class SetGenerator {

    public static Map<Nonterminal, Set<GeneralSymbol>> getFirst(Grammar g) {

        if (g == null) throw new NullPointerException("g nao pode ser nula.");

        Map<Nonterminal, Set<GeneralSymbol>> first = initializeNonterminalMapping(g);
        /*
         * Implemente aqui o método para retornar o conjunto first
         */

        Set<GeneralSymbol> aux = new HashSet<>();
        //TODO executar o laco até que first não seja mais atualizado
        for (int i=0; i<10; i++) {
            for (Production element : g.getProductions()) {
                //caso o primeiro elemento da producao seja um SpecialSymbol epsilon ou um terminal
                if (element.getProduction().get(0).equals(SpecialSymbol.EPSILON) || ((Symbol) element.getProduction().get(0)).isTerminal()) {
                    //coloca em aux os elementos que ja estao no first do nao terminal em questao
                    aux.addAll(first.get(element.getNonterminal()));
                    //adiciona o primeiro elemento da producao atual
                    aux.add(element.getProduction().get(0));
                    //atualiza o first
                    first.put(element.getNonterminal(), aux);
                    //reseta o aux
                    aux = new HashSet<>();
                }
                //caso o primeiro elemento seja um nao terminal
                else if (!((Symbol) element.getProduction().get(0)).isTerminal()) {
                    //caso nao tenha epsilon no first desse nao terminal
                    if (!first.get(element.getProduction().get(0)).toString().contains(SpecialSymbol.EPSILON.toString())) {
                        //coloca em aux os elementos que ja estao no first do nao terminal
                        aux.addAll(first.get(element.getNonterminal()));
                        //verifica se o nao terminal aparece em outras producoes e adiciona o first das outras ocorrencias em aux
                        for (Production subElement : g.getProductions()) {
                            if (subElement.getNonterminal().toString().equals(element.getProduction().get(0).toString())) {
                                aux.addAll(first.get(subElement.getNonterminal()));
                            }
                        }
                        //atualiza o first
                        first.put(element.getNonterminal(), aux);
                        //reseta o aux
                        aux = new HashSet<>();
                    }


                    //caso tenha epsilon no first desse nao terminal
                    if (first.get(element.getProduction().get(0)).toString().contains(SpecialSymbol.EPSILON.toString())) {
                        //coloca em aux os elementos que ja estao no first do nao terminal
                        aux.addAll(first.get(element.getNonterminal()));

                        GeneralSymbol nonTerminalSymbol;
                        GeneralSymbol nonTerminalSymbolNext;
                        //enquanto o proximo elemento for um nao terminal com epsilon no first, pega o first desse nao terminal
                        for (int j = 0; first.get(element.getProduction().get(j)).contains(SpecialSymbol.EPSILON); j++) {
                            nonTerminalSymbol = element.getProduction().get(j);
                            for (Production subElement : g.getProductions()) {
                                if (subElement.getNonterminal().toString().equals(nonTerminalSymbol.toString())) {
                                    aux.addAll(first.get(subElement.getNonterminal()));
                                }
                            }
                            nonTerminalSymbolNext = element.getProduction().get(j + 1);
                            //caso haja outras ocorrencias do nao terminal, adiciona o first das outras ocorrencias em aux
                            for (Production subElement : g.getProductions()) {
                                if (subElement.getNonterminal().toString().equals(nonTerminalSymbolNext.toString())) {
                                    aux.addAll(first.get(subElement.getNonterminal()));
                                }
                            }
                        }
                        //remove o epsilon de aux
                        aux.remove(SpecialSymbol.EPSILON);
                        //atualiza o first
                        first.put(element.getNonterminal(), aux);
                        //e reseta aux
                        aux = new HashSet<>();
                    }
                }
            }
        }

        return first;
    }

    public static Map<Nonterminal, Set<GeneralSymbol>> getFollow (Grammar g, Map<Nonterminal, Set<GeneralSymbol>> first) {

        if (g == null || first == null)
            throw new NullPointerException();

        Map<Nonterminal, Set<GeneralSymbol>> follow = initializeNonterminalMapping(g);

        /*
         * Implemente aqui o método para retornar o conjunto follow
         */

        Set<GeneralSymbol> aux = new HashSet<>();
        boolean starter = true;

        //TODO executar o laco até que follow não seja mais atualizado
        for(int i=0; i<10; i++) {
            for(Production element : g.getProductions()) {
                //caso seja o primeiro, adiciona $ no follow
                if(starter) {
                    aux.add(SpecialSymbol.EOF);
                    follow.put(element.getNonterminal(), aux);
                    starter = false;
                    aux = new HashSet<>();
                }
                int index = 0;
                for(GeneralSymbol subElement : element.getProduction()) {
                    //caso subElement seja um epsilon ou um nao terminal
                    if(subElement.equals(SpecialSymbol.EPSILON) || !((Symbol)subElement).isTerminal()) {
                        //caso subElement seja o ultimo elemento da producao em questao
                        if(element.getProduction().get(element.getProduction().size()-1).equals(subElement)) {
                            //coloca em aux os elementos que ja estao no follow do nao terminal
                            aux.addAll(follow.get(element.getNonterminal()));
                            //caso haja outras ocorrencias do nao terminal, adiciona o follow dessas outras ocorrencias em aux e atualiza o follow
                            for(Nonterminal nElement : g.getNonterminals()) {
                                if(nElement.toString().equals(subElement.toString())) {
                                    aux.addAll(follow.get(nElement));
                                    follow.put(nElement , aux);
                                }
                            }
                            //reseta aux
                            aux = new HashSet<>();
                        }
                        else {
                            //caso tenha nao terminal depois
                            if(!((Symbol)(element.getProduction().get(index+1))).isTerminal()){
                                //caso o first  do nao Terminal tenha um epsilon
                                if(first.get(element.getProduction().get(index+1)).contains(SpecialSymbol.EPSILON)) {
                                    //coloca os elementos que ja estavam no first do nao terminal em aux
                                    aux.addAll(first.get(element.getProduction().get(index+1)));
                                    //remove epsilon de aux
                                    aux.remove(SpecialSymbol.EPSILON);
                                    //coloca os elementos que ja estavam no follow do nao terminal em aux
                                    aux.addAll(follow.get(element.getProduction().get(index+1)));
                                    //coloca tambem o follow do nao terminal subElement em aux
                                    aux.addAll(follow.get(subElement));
                                    //verificacao de outras ocorrencias e atualizacao do follow
                                    for(Nonterminal nElement : g.getNonterminals()) {
                                        if(nElement.toString().equals(subElement.toString())) {
                                            follow.put(nElement, aux);
                                        }
                                    }
                                }
                                //caso o first do nao terminal nao tenha epsilon
                                if(!first.get(element.getProduction().get(index+1)).contains(SpecialSymbol.EPSILON)) {
                                    //coloca os elementos que ja estavam no first do nao terminal em aux
                                    aux.addAll(first.get(element.getProduction().get(index+1)));
                                    //remove epsilon
                                    aux.remove(SpecialSymbol.EPSILON);
                                    //coloca os elementos que ja estavam no follow do nao terminal subElement em aux
                                    aux.addAll(follow.get(subElement));
                                    //verificacao de outras ocorrencias e atualizacao do follow
                                    for(Nonterminal nElement : g.getNonterminals()) {
                                        if(nElement.toString().equals(subElement.toString())) {
                                            follow.put(nElement, aux);
                                        }
                                    }
                                }
                            }
                            //caso tenha terminal depois
                            if(((Symbol)(element.getProduction().get(index+1))).isTerminal()) {
                                //coloca o terminal em aux
                                aux.add(element.getProduction().get(index+1));
                                //verifica outras ocorrencias do nao terminal subElement, adiciona o follow das outras ocorrencias em aux e atualiza o follow
                                for(Nonterminal nElement : g.getNonterminals()) {
                                    if(nElement.toString().equals(subElement.toString())) {
                                        aux.addAll(follow.get(nElement));
                                        follow.put(nElement , aux);
                                    }
                                }
                            }
                            //reseta aux
                            aux = new HashSet<>();
                        }
                    }

                    index++;
                }
            }
        }

        return follow;
    }

    //método para inicializar mapeamento nãoterminais -> conjunto de símbolos
    private static Map<Nonterminal, Set<GeneralSymbol>> initializeNonterminalMapping(Grammar g) {
        Map<Nonterminal, Set<GeneralSymbol>> result =
                new HashMap<Nonterminal, Set<GeneralSymbol>>();

        for (Nonterminal nt: g.getNonterminals())
            result.put(nt, new HashSet<>());

        return result;
    }

}
