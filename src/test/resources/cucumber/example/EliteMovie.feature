Feature: Elite movie test example

Scenario: Display the films
	Given the main page
	When consult the movies list
	Then should be display:
        | El Violinista del Diablo               |
        | El libro de la vida                    |
        | Donde se esconde el diablo             |
        | Primicia Mortal                        |
        | Relatos Salvajes                       |
        | Éxodo, Dioses y Reyes                 |
        | Pancho, el perro millonario            |
        | Petecuy, la película                  |
        | Stockholm                              |
        | Los Juegos del Hambre: Sinsajo Parte 1 |

Scenario: Reserve seats
	Given the showtime 3
	And the seats:
		|row|column|
		| 0 | 8    |
		| 0 | 0	   |
	When reserve the seats
	And obtain the showtime
	Then the seats should be booked
