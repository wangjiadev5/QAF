@Web
Feature: Google Search

  @WanBo
  Scenario: WanBo
    Given I am openning wanbo url

  @daletou
  Scenario Outline: daletou
    Given I am openning daletou "<url>"
    And get caipiao table
    Examples:
      | url                                                                                |
      | https://match.lottery.sina.com.cn/lotto/pc_zst/index?lottoType=dlt&actionType=chzs |

  @zhibo8
  Scenario Outline: zhibo8
    Given Start zhibo8 app
    Examples: