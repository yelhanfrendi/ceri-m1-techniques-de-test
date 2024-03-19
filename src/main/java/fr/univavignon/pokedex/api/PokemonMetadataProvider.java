package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{
    private final Map<Integer, PokemonMetadata> pokemonMetadataMap;



    public PokemonMetadataProvider() {
        pokemonMetadataMap = new HashMap<>();
        pokemonMetadataMap.put(0, new PokemonMetadata(0, "Bulbizarre", 118, 118, 90));
        pokemonMetadataMap.put(1, new PokemonMetadata(1, "Aquali", 151, 151, 120));

    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!pokemonMetadataMap.containsKey(index)) {
            throw new PokedexException("Invalid Pokémon index: " + index);
        }
        return pokemonMetadataMap.get(index);
    }
}


