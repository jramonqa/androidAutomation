Feature: Coppel mobile test cases

  Scenario: Buscar Superheroes
    Given Lanzar aplicacion superheroes
    When Buscar a "Animal Man"
    Then  Validar coincidencia

    Scenario: Seleccionar 3 Favoritos
      Given Lanzar aplicacion superheroes
      When Seleccionar tres SuperHeroes a favoritos
      Then Validar esten en favoritos

      Scenario: Deseleccionar Favoritos
        Given Lanzar aplicacion superheroes
        When Deseleccionar los tres favoritos
        Then Validar Favoritos este Vacios

