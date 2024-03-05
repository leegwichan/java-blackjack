package blackjack.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeckTest {

    @DisplayName("카드 한 장을 뽑을 수 있다")
    @Test
    void drawTest() {
        Deck deck = new Deck();

        assertThat(deck.draw()).isNotNull();
    }

    // TODO 테스트 네이밍 고민
    @DisplayName("카드는 최대 52장만 뽑을 수 있다.")
    @Test
    void drawTest_whenDraw53Times_throwException() {
        Deck deck = new Deck();
        drawRepeat(deck, 52);

        assertThatThrownBy(() -> deck.draw())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("카드를 더 이상 뽑을 수 없습니다.");
    }

    private void drawRepeat(Deck deck, int times) {
        for (int i = 0; i < times; i++) {
            deck.draw();
        }
    }
}