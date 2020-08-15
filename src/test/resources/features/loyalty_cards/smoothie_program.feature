Feature: Super Smoothie Loyalty Card Program

  The more smoothies you buy, the more smoothies you earn

  Background:
    Given the following drink categories
      | Drink              | Category | Points |
      | Banana             | Regular  | 15     |
      | Triple Berry Blend | Fancy    | 20     |
      | Earl Grey          | Tea      | 10     |

  Scenario Outline: Earnings points when purchasing smoothies
    Given Lucas is a morning Freshness Member
    When Lucas purchases <Quantity> <Drink> drinks
    Then he should earn <Points> points

    Examples:
      | Drink              | Quantity | Points |
      | Banana             | 2        | 30     |
      | Triple Berry Blend | 1        | 20     |
      | Earl Grey          | 3        | 30     |
