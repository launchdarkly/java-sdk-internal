package com.launchdarkly.sdk.internal.events;

/**
 * Callback interface for determining whether the network is available.
 * <p>
 * The server-side SDK will not provide any implementation of this, because it assumes that it is
 * always online. The client-side SDK will provide an implementation that tells DefaultEventProcessor
 * we are offline if the network is not available, or if the client has been deliberately configured
 * to be offline.
 */
public interface ConnectionStatusMonitor {
  /**
   * Returns true if the network is available (as far we know) and the SDK is supposed to be online.
   * DefaultEventProcessor will skip trying to deliver any events if this returns false.
   * <p>
   * This method must be thread-safe. It will be called every time DefaultEventProcessor is
   * considering sending some events. 
   * 
   * @return true if connected, false if offline for any reason
   */
  boolean isConnected();
}
