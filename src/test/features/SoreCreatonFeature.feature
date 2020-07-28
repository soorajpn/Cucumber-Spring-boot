Feature:Store creation

    Scenario: create an store
        Given configure Store controll
        When we givan store to create
            | name     |  descriptioin  |  phone   |
            | hotweels | toy store      | 100      |
        Then find all and check for
            | name     |  descriptioin  |  phone   |
            | hotweels | toy store      | 100      |



