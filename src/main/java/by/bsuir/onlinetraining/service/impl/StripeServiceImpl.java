package by.bsuir.onlinetraining.service.impl;

import by.bsuir.onlinetraining.models.Course;
import by.bsuir.onlinetraining.service.StripeService;
import com.stripe.Stripe;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StripeServiceImpl implements StripeService {
    @Value("${stripe.key.secret}")
    private String stripeKey;

    @Override
    @SneakyThrows
    public String createPaymentLinkForCourse(Course course) {
        Stripe.apiKey = stripeKey;

        ProductCreateParams productCreateParams = ProductCreateParams.builder()
                .setName(course.getName())
                .build();
        Product product = Product.create(productCreateParams);

        PriceCreateParams priceCreateParams = PriceCreateParams.builder()
                .setProduct(product.getId())
                .setCurrency("BYN")
                .setUnitAmount((long) (course.getPrice().doubleValue() * 100))
                .build();
        Price price = Price.create(priceCreateParams);
        String redirectUrl = String.format("http://localhost:3000/after-payment/%s", course.getId());

        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(
                                PaymentLinkCreateParams.AfterCompletion.builder()
                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                        .setRedirect(
                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                        .setUrl(redirectUrl)
                                                        .build()
                                        )
                                        .build()
                        )
                        .build();
        PaymentLink paymentLink = PaymentLink.create(params);

        return paymentLink.getUrl();
    }
}
