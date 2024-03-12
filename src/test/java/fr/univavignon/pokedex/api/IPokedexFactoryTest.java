package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {


    IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
    IPokemonMetadataProvider metadataProvider =  mock(IPokemonMetadataProvider.class);
    IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

    @Test
    public  void creationPokedex() {
        when(pokedexFactory.createPokedex(any(), any())).thenAnswer(new Answer<IPokedex>() {
            public IPokedex answer(InvocationOnMock invocation) {
                IPokedex pokedex = mock(IPokedex.class);
                when(pokedex.size()).thenReturn(0);
                return pokedex;
            }
        });


        IPokedex pokedex =  pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        assertEquals(0, pokedex.size());


    }
}
