package com.karcompany.productsearch;

/**
 * Created by pvkarthik on 2017-01-26.
 *
 * Presenter unit test cases.
 */

import com.karcompany.productsearch.config.AppConfig;
import com.karcompany.productsearch.models.ProductSearchApiResponse;
import com.karcompany.productsearch.networking.ApiRepo;
import com.karcompany.productsearch.presenters.BrowseProductsPresenter;
import com.karcompany.productsearch.presenters.BrowseProductsPresenterImpl;
import com.karcompany.productsearch.views.BrowseProductsView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import rx.Subscription;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(RobolectricGradleTestRunner.class)
// Change what is necessary for your project
@Config(constants = BuildConfig.class, sdk = 21, manifest = "/src/main/AndroidManifest.xml")
public class BrowseProductsPresenterTest {

	@Mock
	private ApiRepo model;

	@Mock
	private BrowseProductsView view;

	@Mock
	private AppConfig appConfig;

	private BrowseProductsPresenter presenter;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		presenter = new BrowseProductsPresenterImpl(model, appConfig);
		presenter.setView(view);
		/*
			Define the desired behaviour.

			Queuing the action in "doAnswer" for "when" is executed.
			Clear and synchronous way of setting reactions for actions (stubbing).
			*/
		doAnswer(new Answer() {
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				ProductSearchApiResponse productSearchApiResponse = new ProductSearchApiResponse();
				((ApiRepo.GetImagesApiCallback) presenter).onSuccess(productSearchApiResponse);
				return Mockito.mock(Subscription.class);
			}
		}).when(model).getProducts(0, "test", (ApiRepo.GetImagesApiCallback) presenter);
	}

	/**
	 Verify if model.getImages was called once.
	 Verify if view.onDataReceived is called once with the specified object
	 */
	@Test
	public void testFetchProducts() {
		presenter.loadProducts(0, "test");
		// verify can be called only on mock objects
		verify(model, times(1)).getProducts(0, "test", (ApiRepo.GetImagesApiCallback) presenter);
		verify(view, times(1)).onDataReceived(any(ProductSearchApiResponse.class));
	}

}
