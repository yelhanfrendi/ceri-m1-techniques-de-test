package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        String name;
        int attack;
        int defense;
        int stamina;


        try{
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
        name=metadata.getName();
        attack=metadata.getAttack();
        defense=metadata.getStamina();


        } catch (PokedexException e) {
            throw new RuntimeException(e.getMessage());
        }

        return null;
    }
}
